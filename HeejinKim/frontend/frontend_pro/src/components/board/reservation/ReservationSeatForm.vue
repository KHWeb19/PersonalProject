<template>

  <v-container class="place" justify="center">
    <v-form @submit.prevent="onSubmit">
      
    <v-row justify="center">
      <v-col cols="8" class="label" style="font-size:20pt">Libarary Seat Booking</v-col>            
    </v-row>
    
    <v-row justify="center">
      <v-col cols="2" class="label">userId</v-col>
      <v-col>
        <v-text-field rounded style="width:80px" readonly :value="this.userId"/>
      </v-col>
    </v-row>
<!--
    <v-row>
      <v-col>
        <v-date-picker v-model="seatTime"></v-date-picker>      
      </v-col>
    </v-row>-->

     <v-row>
        <v-col cols="1" class="label"> Date</v-col>
        <v-col>
            <v-text-field class="date" rounded readonly :value="reservation.regDate"/>
        </v-col>
      </v-row>

    <v-row>
      <v-col>
       <div class="llabel ml-5"> available seats </div>
      </v-col>
    <v-col v-model="restSeats"> 
      <div class="llabel mr-5"> {{this.restSeats}} </div>
        
    </v-col>     

    </v-row>

    <v-row justify="center">
      <v-col>
        <ul class="showcase">
          <li>
            <div class="seat avail"></div>
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
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <div class="llabel">selected seat : {{seatNumber}} </div>
      </v-col>
    </v-row>
    
    
      
    <!--
      <v-col v-model="seatTime">
        <div class="llabel" >Today {{this.regDate}}</div>
      </v-col>
    </v-row>
      
      <v-col cols="1">
        <v-btn @click="restBtn()" v-model="restSeats"> Available seats </v-btn>
      </v-col>
      <v-spacer></v-spacer>-->
     
    <v-row>
      <v-col>
        <table class="container ml-3">
          <tbody>
            <tr v-for="(i, idx) in seatRows" :key="idx">
              <td v-for="(j, idx) in seatCols" :key="idx" >
                <button @click="test(String(i)+String(j),$event)"
                  v-bind:id="i + j"
                  v-bind:ref= "i + j" 
                  class="seat">
                  {{ i }}{{ j }}
                </button>
              </td>
            </tr>
          </tbody>
        </table>
       
      </v-col>
    </v-row> 

    <v-row>
      <v-btn class="selectSeatBtn" type="submit" dark>
       select</v-btn>
      
    </v-row>
      
    <!--<button @click="check(apblist[i]+j, $event)"
      v-bind:id="apblist[i]+j"
      v-bind:ref= "i + j" 
      class="seat">
      {{ apblist[i] }}{{ j }}
      +'-'+
    </button>-->
    </v-form>
    
 </v-container>
</template>

<script>

import { mapActions } from 'vuex'

export default {

  

  name:'ReservationSeatForm',

  props: {
        reservation: {
            type: Object,
            required: true
        }
    },

  data() {
    return {
      seatNumber:[],
      //seatTime: [],
      seatRows: 3,
      seatCols: 5,
      restSeats: 15, 
      bookInfo:[] ,
      //seatTime:[],
       //(new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),  
    }
  }, 
  created(){

      this.reservationNo = this.reservation.reservationNo
      this.userId = this.$store.state.session.userId
      //this.regdate = this.$store.state.board.regdate
      //this.seatTime = this.$store.state.seatTime
      //this.seatNumber = this.$store.state.seatNumber
      //this.restSeats = this.$store.state.restSeats
      //this.fetchReservation(this.reservationNo)
    
    },
 
  methods: {

     ...mapActions(['fetchReservationList','fetchReservation']),

    test(seatNum,event) {
      console.log(seatNum)
      this.seatNumber = seatNum 
      this.$store.state.seatNumber = this.seatNumber      
      this.$store.state.restSeats = this.restSeats--


      if (event.currentTarget.style.background == "goldenrod") {
        event.currentTarget.style = "background:"
        this.bookInfo.pop()

      }else if(event.currentTarget.style.background != "black"){

        event.currentTarget.style = "background:goldenrod"
        this.bookInfo.push(seatNum) 
        //this.seatNumber = seatNum
      } 

      let seatflag=0

      for(var i=0;i<this.blackseat.length;++i){
        if(seatNum == this.blackseat[i]){
          alert('이미 선택된 좌석입니다.다른 자리 선택하세요')  
          seatflag=1;
        }
      }
      if(seatflag == 1 ){
        this.bookInfo.pop()
      }         
    },
    
    //디비로 확정 정보 넣는 것(reservation 쪽에)--날리기
    onSubmit  () {
      const { seatTime, seatNumber,restSeats} = this
                
      this.$emit('submit', { seatTime, seatNumber,restSeats})

      console.log(seatTime,seatNumber,restSeats)
    },
    

/*
    finish(payload) { 
      
      const{seatTime,seatNumber,restSeats,}=payload

      axios.post(`http://localhost:7777/reservation/finish`,{seatTime, seatNumber,restSeats})
        .then(() => {
          this.seatTime = ''
          this.seatNumber= ''
          this.restSeats = ''
          console.log(this.restSeats)
         
        })
        .catch(() => {
          alert('예약 남은자리, 번호, 타임 넣는데 문제!')
        })
    }
     /*
    getSeatNumber(payload) {

      const { restSeats,seatNumber,seatTime } = payload
      
      axios.post(`http://localhost:7777/reservation/finish`,{ restSeats,seatNumber,seatTime})
        .then( res => {
          this.restSeats = res.data.restSeats
          console.log(this.restSeats)
          this.seatNumber = res.data.seatNumber
          this.seatTime = res.data.seatTime
        })
        .catch(() => {
          alert('예약 남은자리, 번호, 타임 넣는데 문제!')
        })
                
    },*/
      

      /*
      //selectTime(){
      //console.log('select time')
      //this.$store.state.seatTime = seatTime
      //const seatTime = this
    
    //},
      ,
     test(seatNum) {
      console.log(seatNum);
      this.seatsInfo = this.seatsInfo + " " + seatNum;      
      this.restSeats--;
    }
      axios
      .put("http://localhost:7777/reservation/finish/${reservationNo}?seatNumber=" + this.seatNumber + "&seatTime=" + this.seatTime)
      .then(res => {
          console.log(res)
        this.seatTime = res.data.seatTime
        this.seatNumber = res.data.seatNumber
        this.$router.push('/finish')

      })
      .catch(() => {
        alert('자리 배열 업데이트 문제발생')
      })*/
        
    
         /*----이건 파라메터로 날리는 거(원래)
         axios
      .post("http://localhost:7777/reservation/finish/seat", null, {
        params: {
          seatTime: this.seatTime,
          seatNumber: this.seatsInfo
        }
      })
      .then(response => {
        console.log(response)
      })


        const {seatTime, seatNumber} = payload
      axios.post(`http://localhost:7777/reservation/finish/seat`,{seatTime, seatNumber})
          params: {
            this.time = ''
            this.password = ''
            time: this.time,
            //seatNumber: this.seatsInfo, 여기서 변환 과정에서 막힘 

            //movieName: this.movieName,
            //phoneNumber: this.phoneNumber,                     
            //prices: this.prices,
            //hallNumber: this.hallNumber
          }
        })
    },*/
    /*
    //update rest seats
    finish(payload){   
      const { seatTime, seatNumber} = payload
     

      axios.put(`http://localhost:7777/reservation/finish/${reservationNo}`,{seatTime, seatNumber})
      .then(res => {
        console.log(res)
        this.seatTime = res.data.seatTime
        this.seatNumber = res.data.seatNumber
        this.$router.push('/finish')

      })
      .catch(() => {
        alert('자리 배열 업데이트 문제발생')
      })
    },*/



  //<router-link :to="{name: 'finish', query: {phoneNumber : phoneNumber, movieName: movieName, time: time, people: people, seatNumber: seatNumber, prices: prices, hallNumber: hallNumber}}">확인</router-link>
  //이거는 푸시해서 예매내역 조회쪽으로 옮기는 과정 
/*
    this.$router.push({
    name: "ReservationFinish",
    query: {

      seatTime: this.seatTime,
      seatNumber: this.seatsInfo,
      
      //phoneNumber: this.phoneNumber,
      //movieName: this.movieName,          
      //people: this.people,          
      //prices: this.prices,
      //hallNumber: this.hallNumber,
    },
  })
    },*/

   
  }
}
</script>

<style>

 


.llabel{
  font-family: 'Ubuntu', sans-serif; 
  font-size: 17px;
}
.label{
  font-family: 'Ubuntu', sans-serif; 
  font-size: 15pt;
  margin-right:5%;
  text-align: center;
  padding-top: 25px; 
}
.place{
    background-color: #f8f8f8;
    padding: 5% 10% 5% 10%;
    margin-top:30px;
    margin-left:auto;
    margin-right:auto;
    margin-bottom:30px;
    width: 700px;
}
.container {
  perspective: 700px;
  padding: 5% 10% 5% 10%;
  border-collapse: separate;
  
}
.v-text-field, .v-textarea{
    font-family: 'Sunflower', sans-serif;
}
.seat {
  color: #777;
  background-color:rgba(128, 128, 128, 0.199);
  height:40px;
  width: 45px;
  margin: 3px;
  font-size: 13px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
  
}
.seat.avail{
  height:30px;
  width: 36px;
  background-color:rgba(128, 128, 128, 0.199);
}
.seat.selected {
  background-color: goldenrod;
  height:30px;
  width: 36px;
}
.seat.sold {
  background-color: black;
  height:30px;
  width: 36px;
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
  width: 420px;
 
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
.rrow {
  display: flex;
  height:300px;
}
.selectSeatBtn{
  margin-top: 5%;
  margin-left: 170px;  
}
.infos{
  grid-template-rows: repeat(300,50fr);
}
.oneseat{
  color: blueviolet;
}

</style>