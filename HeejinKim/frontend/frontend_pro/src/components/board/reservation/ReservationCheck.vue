<template>
  <v-container>
    <v-form @submit.prevent="onUpdate">
      <table>
        <v-row justify="center">
          <v-col cols="12" class="label mt-5 ml-4" >{{this.userId}} 님 reservation </v-col>
        </v-row>
        
         <v-row>
                <v-col cols="1" class="label"> Date</v-col>
                <v-col>
                    <v-text-field class="date" rounded readonly :value="reservation.regDate"/>
                </v-col>
            </v-row>

            <v-row>
        <v-col cols="1" class="label"> Reservation No</v-col>
        <v-col v-for="reservation in reservation" :key="reservation.reservationNo">
            {{ reservation.reservationNo }}
        </v-col>
      </v-row>


        <v-row>
          <v-col cols="6" class="label"> Seat Number </v-col>
          <v-col>
            <v-text-field rounded style="width:150px" readonly :value="reservation.seatNumber"/>
          </v-col>
        </v-row>
         <v-row>
           <v-col cols="6" class="label"> 남은좌석수 </v-col>
          <v-col>
              <v-text-field rounded style="width:150px" readonly :value="reservation.restSeats"/>
          </v-col>

          </v-row>
                <!--
          <v-col>
            {{$route.params.seatNumber}}
            <v-text-field rounded  readonly :value="reservation.seatNumber"/> 
          </v-col> 
        

        <v-row>
          <v-col cols="6" class="label"> 남은좌석수 </v-col>
          <v-col>
            {{$route.params.restSeats}}
            -------<v-text-field rounded  readonly :value="reservation.seatNumber"/> ----
          </v-col>
        </v-row>-->


        <v-row justify="center">
          <v-btn  type="submit" class="updateBtn" dark> submit </v-btn>
        </v-row>     
      </table>
    </v-form>
   
    <!--
    <div class="input">
        <hr>
      <table class = "tableStyle">
        <thead>           
          <th>시간</th>     
          <th>좌석</th>
        </thead>

        <tbody>
          <tr v-for="(data, index) in bookingInfo" :key="index">
            <td>{{data.time}}</td> 
            <td>{{data.seatNumber}}</td>
          </tr>
        </tbody>
      </table>
    </div>-->
  
   </v-container>
</template>

<script>

import { mapActions } from 'vuex'
//import axios from 'axios'
export default {

    name:'ReservationCheck',
    
    props: {
        reservation: {
            type: Object,
            required: true
        }
    },


  data() {
    return {

      //seatNumber: "",
      //restSeats:""
    }
  },
  /*
  computed:
    {
      ...mapState(['seatTime','seatNumber','restSeats']),    
    },*/
  created  () {   
    this.userId = this.$store.state.session.userId
    this.reservationNo = this.reservation.reservationNo
    //this.seatTime = this.$route.params.seatTime
    //this.seatNumber = this.$route.params.seatNumber 파라메터로 날라온것들 
    //this.restSeats = this.$route.params.restSeats
    },
    /*
  mounted() {
    this.phoneNumber = this.$route.query.phoneNumber;
    console.log(this.phoneNumber);
    axios
      .get("/movie/check/" + encodeURI(this.phoneNumber))
      .then(response => {
        this.bookingInfo = response.data;
      });
  },*/
  methods: {

    ...mapActions(['fetchReservation']),

    onUpdate () {
      const { seatNumber,restSeats} = this.reservation
                
      this.$emit('submit', {  seatNumber,restSeats})

      },
  }
}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Poiret+One&family=Sunflower:wght@300&family=Ubuntu:wght@300&display=swap");

.label{

    font-family: 'Ubuntu', sans-serif; 
    font-size: 17pt;
    margin-right:5%;
    text-align: center;
    padding-top: 50px; 
}

table{
  background-color: #f3f3f3;
  padding: 5% 10% 5% 10%;
  margin-left:auto;
  margin-right:auto;
  width:500px;
  height: 500px;
}
.updateBtn{
  color:rgba(214, 86, 103, 0.596);  
  margin-top: 70px;

}
.v-text-field, .v-textarea{
    font-family: 'Sunflower', sans-serif;
}
.addImg {
    position: relative;
    max-height: 400px;
    max-width: 500px;
}
</style>