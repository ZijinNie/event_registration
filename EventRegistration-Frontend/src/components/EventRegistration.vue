<template>
  <div id="eventregistration">
    <h2>Persons</h2>
    <table id="persons-table">
      <tr>
        <th>Name</th>
        <th>Events</th>
        <th>Payment ID</th>
        <th>Amounts($)</th>
      </tr>
      <tr v-for="(person, i) in persons" v-bind:key="`person-${i}`">
        <td>{{person.name}}</td>
        <div v-for="(event, i) in person.eventsAttended" v-bind:key="`event-${i}`" style="list-style-type: disc;">
          <td>
            <ul>
              <!-- <li v-for="(event, i) in person.eventsAttended" v-bind:key="`event-${i}`" style="list-style-type: disc;"> -->
              <li>
                <span class='registration-event-name'>{{event.name}}</span>
              </li>
            </ul>
          </td>
          <td>
            {{event.deviceId}}
          </td>
          <td>
            {{event.amount}}
          </td>
        </div>

      </tr>

      <tr>
        <td>
          <input id="create-person-person-name" type="text" v-model="newPerson" placeholder="Person Name">
        </td>
        <td>
          <select id='create-person-person-type' v-model="personType">
          <option disabled value="">Please select one</option>
          <option value="person">Person</option>
          <option value="promoter">Promoter</option>
          </select>
        </td>
        <td>
          <button id="create-person-button" v-bind:disabled="!newPerson" @click="createPerson(personType, newPerson)">Create Person</button>
        </td>
        <td></td>
        <td></td>
      </tr>
    </table>
    <span v-if="errorPerson" style="color:red">Error: {{errorPerson}}</span>

    <hr>
    <h2>Events</h2>
    <table id='events-table'>
      <tr>
        <th>Name</th>
        <th>Date</th>
        <th>Start</th>
        <th>End</th>
        <th>Make</th>
      </tr>
      <tr v-for="(event, i) in events" v-bind:id="event.name" v-bind:key="`event-${i}`">
        <td v-bind:id="`${event.name.replace(/\s/g, '-')}-name`">{{event.name}}</td>
        <td v-bind:id="`${event.name.replace(/\s/g, '-')}-date`">{{event.date}}</td>
        <td v-bind:id="`${event.name.replace(/\s/g, '-')}-starttime`">{{event.startTime}}</td>
        <td v-bind:id="`${event.name.replace(/\s/g, '-')}-endtime`">{{event.endTime}}</td>
        <td v-bind:id="`${event.name.replace(/\s/g, '-')}-make`">{{event.make}}</td>
      </tr>
      <tr>
        <td>
          <input id="event-name-input" type="text" v-model="newEvent.name" placeholder="Event Name">
        </td>
        <td>
          <input id="event-date-input" type="date" v-model="newEvent.date" placeholder="DD-MM-YYYY">
        </td>
        <td>
          <input id="event-starttime-input" type="time" v-model="newEvent.startTime" placeholder="HH:mm">
        </td>
        <td>
          <input id="event-endtime-input" type="time" v-model="newEvent.endTime" placeholder="HH:mm">
        </td>
        <td>
          <input id="event-make-input" type="text" v-model="newEvent.make" placeholder="Make">
        </td>
        <td>
          <button id="event-create-button" v-bind:disabled="!newEvent.name" v-on:click="createEvent(newEvent)">Create</button>
        </td>
      </tr>
    </table>
    <span id="event-error" v-if="errorEvent" style="color:red">Error: {{errorEvent}}</span>
    <hr>
    <h2>Registrations</h2>
    <label>Person:
        <select id='registration-person-select' v-model="selectedPerson">
          <option disabled value="">Please select one</option>
          <option v-for="(person, i) in persons" v-bind:key="`person-${i}`">{{person.name}}</option>
        </select>
    </label>
    <label>Event:
      <select id='registration-event-select' v-model="selectedEvent">
        <option disabled value="">Please select one</option>
        <option v-for="(event, i) in events" v-bind:key="`event-${i}`">{{event.name}}</option>
      </select>
    </label>
    <button id='registration-button' v-bind:disabled="!selectedPerson || !selectedEvent" @click="registerEvent(selectedPerson, selectedEvent)">Register</button>
    <br/>
    <span v-if="errorRegistration" style="color:red">Error: {{errorRegistration}}</span>
    
    <hr>
    <h2>Assign Professionals</h2>
    <label >Promoter
      <select id='assign-selected-promoter' v-model="selectedPromoter">
        <option disabled value="">Please select one</option>
        <option v-for="(promoter, i) in promoters" v-bind:key="`promoter-${i}`">{{promoter.name}}</option>
      </select>
    </label>
    <label>Event:
      <select id='assign-selected-event-promoter' v-model="selectedEventP">
        <option disabled value="">Please select one</option>
        <option v-for="(event, i) in events" v-bind:key="`event-${i}`">{{event.name}}</option>
      </select>
    </label>
    <button id='assign-button-promoter' v-bind:disabled="!selectedPromoter || !selectedEventP" @click="assignEvent(selectedPromoter, selectedEventP)">Assign</button>
    <span id="assign-error" v-if="errorAssign" style="color:red">Error: {{errorAssign}}</span>

    <br/>

    <hr>
    <h2>Pay for Registration with CreditCard</h2>
    <br>
    <!-- <div v-for="(person, i) in persons" v-bind:key="`person-${i}`"> -->
      <label>Person:
          <select id='credit-card-person-select' v-model="selectedPersonC">
            <option disabled value="">Please select one</option>
            <option v-for="(person, i) in persons" v-bind:key="`person-${i}`">{{person.name}}</option>
            <!-- <option>{{person.name}}</option> -->
          </select>
      </label>

      <label>Event:
        <select id='credit-card-event-select' v-model="selectedEventC">
          <option disabled value="">Please select one</option>
          <!-- <option v-for="(event, i) in person.eventsAttended" v-bind:key="`event-${i}`">{{event.name}}</option> -->
          <option v-for="(event, i) in events" v-bind:key="`event-${i}`">{{event.name}}</option>

        </select>
      </label>
      
    <!-- </div> -->
    <br>
    <label >Device id:
      <input type="text" id="credit-card-id-input" v-model= "deviceId">
    </label>
    <label >Amount:
      <input type="text" id="credit-card-amount-input" v-model= "amount">
    </label>
    <br>
    <button id='credit-card-button' v-bind:disabled="!selectedPersonC || !selectedEventC || !deviceId|| !amount" @click="pay(selectedPersonC, selectedEventC, deviceId, amount)">Make payment</button>
    <br>
    <span id="credit-card-error" v-if="errorPay" style="color:red">Error: {{errorPay}}</span>


  </div>
</template>

<script src="./registration.js"></script>

<style>
#eventregistration {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background: #f2ece8;
  margin-top: 60px;
}
.registration-event-name {
  display: inline-block;
  width: 25%;
}
.registration-event-name {
  display: inline-block;
}
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  text-align: left;
}
a {
  color: #42b983;
}
</style>
