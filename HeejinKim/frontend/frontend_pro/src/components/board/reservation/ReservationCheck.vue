<template>
  <v-container>    
    <table>
      <v-row justify="center">
        <v-col cols="12" class="title1"> Reservation states</v-col>
      </v-row>


      <v-row>
        <v-col cols="6" class="label"> Reservation No</v-col>
        <v-col cols="5">
          <v-text-field class="date pt-8" rounded readonly :value="reservation.reservationNo"/>
        </v-col>
      </v-row>


      <v-row>
        <v-col cols="6" class="label"> Seat Number </v-col>
        <v-col cols="5">
          <v-text-field class="date pt-8" rounded readonly :value="reservation.seatNumber"/>
        </v-col>
      </v-row>


      <v-row justify="center">
        <router-link :to="{ name: 'SeatForm' }"  style=" text-decoration:none">
          <v-btn class="updateBtn" color="#eddf68" > confirm </v-btn>
        </router-link>
        <v-btn @click=onDelete class="deleteBtn" dark>Delete</v-btn>
      </v-row>  

      

    </table>
   </v-container>
</template>

<script>

import { mapActions } from 'vuex'
import axios from 'axios'
export default {

  name:'ReservationCheck',
  
  props: {
    reservation: {
      type: Object,
      required: true
    },
    /*
    reservationNo: {
      type: String,
      required: true
    }*/
  },

  data() {
    return {

    }
  },
  created () {
        //this.reservationNo =  this.$store.state.reservations[0].reservationNo
        //this.reservation = this.$store.state.reservation
        this.id = this.$store.state.session.userId
        this.reservationNo=this.$route.params.reservationNo
    },   
  
  methods: {

    ...mapActions(['fetchReservation']),

    onDelete () {
      const { reservationNo } = this.reservation
      
      axios.delete(`http://localhost:7777/reservation/${reservationNo}`, )
        .then(() => {
          alert('게시글 삭제')
          this.$router.push({ name: 'Home'})
        })
        .catch(() => {
          alert('삭제 실패')
        })
        },

    
  }
}
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Poiret+One&family=Sunflower:wght@300&family=Ubuntu:wght@300&display=swap");

.title1{  

  font-family: 'Ubuntu', cursive;
  font-size: 30pt;
  margin-right:5%;
  text-align: center;
  padding-top: 20px; 

}
.label{
  font-family: 'Poiret One', cursive;
    font-size: 17pt;
    margin-right:5%;
    text-align: center;
    padding-top: 30px; 
}

table{
  background-color:#f7f7f7;
  padding: 5% 10% 5% 10%;
  margin-left:auto;
  margin-right:auto;
  width:450px;
  height: 500px;
}
.updateBtn{
   color:white;
  margin-top: 60px;
  margin-right: 20px;

}
.v-text-field, .v-textarea{
    font-family: 'Sunflower', sans-serif;
}

.deleteBtn{
  color:rgba(214, 190, 86, 0.822); 
  margin-top: 60px;

}
</style>
<!--
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
            <v-col>
             <v-text-field class="date" rounded readonly :value="reservation.reservationNo"/>
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
                -----------------------------------------------------------
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
        </v-row>--------------------------------------------------------------------------


        <v-row justify="center">
          <v-btn  type="submit" class="updateBtn" dark> submit </v-btn>
        </v-row>     
      </table>
    </v-form>
   
    ------------------------------------------------------------------------
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
    </div>------------------------------------------------------------------------
  
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

    }
  },
  /*
  computed:
    {
      ...mapState(['seatTime','seatNumber','restSeats']),    
    },*/
  created  () {   
    this.userId = this.$store.state.session.userId
    this.reservationNo = this.$store.state.reservations[0].reservationNo
    this.reservation = this.$store.state.reservations[0]
    //this.seatTime = this.$route.params.seatTime
   
    },
  
  methods: {

    ...mapActions(['fetchReservation']),

    onUpdate () {
      const { seatNumber,restSeats} = this.reservation
                
      this.$emit('submit', { seatNumber,restSeats})

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
</style>-->