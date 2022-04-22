<template>
  <v-container class="place" justify="center">
    <table>
      <v-row justify="center">
        <v-col cols="8" class="label" style="font-size:20pt">Libarary Seat Booking</v-col>            
      </v-row>
      
      <v-row>
        <v-col cols="1" class="label">userId</v-col>
        <v-col>
          <v-text-field rounded style="width:100px" readonly :value="this.userId"/>
        </v-col>
      </v-row>
    
      <ul class="showcase">
        <li>
          <div class="seat"></div>
          <small>Available</small>
        </li>

        <li>
          <div class="seat selected"></div>
          <small>Selected</small>
        </li>

        <li>
          <div class="seat sold"></div>
          <small>Sold</small>
        </li>
      </ul>

      <div class="container">  
        <div class="row">
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
        </div>

        <div class="row">
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
        </div>

      </div>

      <p class="text">
      You have selected <span id="count">0</span>
      </p>
  </table> 
  </v-container>   
</template>


<script>

export default {

  name:'ReservationForm',

  data() {
    return {
      
    }
  },
    created () {   
    this.userId = this.$store.state.session.userId
    },

  
}
</script>


<style scoped>
@import url("https://fonts.googleapis.com/css?family=Lato&display=swap");


.label{
  font-family: 'Ubuntu', sans-serif; 
  font-size: 15pt;
  margin-right:5%;
  text-align: center;
  padding-top: 25px; 
}
table{
    background-color: #f8f8f8;
    padding: 5% 10% 5% 10%;
    margin-left:auto;
    margin-right:auto;
    width: 700px;
}
.container {
  perspective: 700px;
  padding: 5% 10% 5% 10%;
}
.v-text-field, .v-textarea{
    font-family: 'Sunflower', sans-serif;
}
.seat {
  background-color: #444451;
  height: 26px;
  width: 32px;
  margin: 3px;
  font-size: 50px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}

.seat.selected {
  background-color: green;
}

.seat.sold {
  background-color: #fff;
}

.seat:nth-of-type(2) {
  margin-right: 18px;
}

.seat:nth-last-of-type(2) {
  margin-left: 18px;
}

.seat:not(.sold):hover {
  cursor: pointer;
  transform: scale(1.2);
}

.showcase .seat:not(.sold):hover {
  cursor: default;
  transform: scale(1);
}

.showcase {
  background: rgba(0, 0, 0, 0.1);
  padding: 10px 10px;
  border-radius: 5px;
  color: #777;
  list-style-type: none;
  display: flex;
  width: 400px;
  justify-content: space-between;
}

.showcase li {
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0 10px;
}
.showcase li small {
  margin-left: 2px;
}

.row {
  display: flex;
}

p.text{
    margin: 5px 0;
}

p.text span{
    color: rgb(158, 248, 158);
}
</style>
