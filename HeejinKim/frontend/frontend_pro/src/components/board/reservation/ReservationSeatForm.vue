<!--<template>
      <v-row>
        <v-col>
          <table class="container"> 
       
            <div class="rrow">
              <tr v-for="(i, idx) in seatRow" :key="idx">
                <th v-for="(j, idx) in seatCol" :key="idx" >
                  <button class="seats" @click="test(String(i) + String(j))"
                    v-bind:id="i + j"
                    v-bind:ref="i + j" 
                    :disabled="false">
                    {{ i }}{{ j }}
                  </button>
                </th>
              </tr>  
            </div> 
          </table>
        </v-col>
      </v-row>               
           -----------여기 
               <div class="rrow">
          <div class="t1"><a id="a1" href="javascript:void(0)"
                onclick='bgcolor(("#a1").text());'>1</a></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
          <div class="seat"></div>
        </div> //여기서 부터는 해제------------
  
      <p class="text">
      You have selected <span id="count">{{seatdata}}</span>
      </p>

      <v-row>
        <v-btn @click="selectSeatBtn" class="selectSeatBtn" dark> select</v-btn>
      </v-row>

  
  </v-container>   
</template>


<script>
import axios from 'axios'

export default {

  name:'ReservationForm',

  data() {
    return {
      seatRow:7,
      seatCol:7,
      selectedSeat:[],
      //seatdata:"",
      
      seatdata:[],
      
    }
  },
   created  () {   
    this.userId = this.$store.state.session.userId;
    this.getSeatsInfo();
    //this.seatsInfo =this.$store.state.session.seatInfo;

  },
  mounted() {   
    
    const { seatNo } = this.seatInfo
    axios.post(`http://localhost:7777/reservation/pickedSeats`, {seatNo})        
      //seatNo 와 Seat_NUM은 같은 것
      .then(res => {
      
        this.$store.state.seatData = res.data 
        this.seatNo =''

        for(var iii=0;iii<res.data.length;++iii){

          this.selectedSeat.push(res.data[iii].seatNo)
          console.log(this.selectedSeat)
        }    
         for(var ii=0; ii<this.selectedSeat.length;++ii){
        document.getElementById(this.selectedSeat[ii]).style = "background:red"   
      }   
      })
      .catch(() =>  {
          alert('좌석 불러오기 실패!')
      })     
  },
  methods: {

    getSeatsInfo() {
      //http://localhost:8080/api/movie/%EC%98%81%EC%9B%85
      const { seatRow,seatCol } = this.seatInfo

      axios.post(`http://localhost:7777/reservation/getSeat`, {seatRow,seatCol})
      .then(res => {    
        this.$store.state.seatdata = res.data    
        this.rows = res.data.rows;
        this.cols = res.data.cols;
        });
    },

    checkSeat(){

      const { seatNumber} = this.seatsInfo
      axios.post(`http://localhost:7777/reservation/pickedSeats`, {seatNumber})

      .then(res => {
         console.log(res);      
      })
       
      /*
      const { seatRow,seatCol } = this.seatInfo

      axios.post(`http://localhost:7777/reservation/pickedSeats`, {seatRow,seatCol})

      .then(res => {

        if(res.data != null ){
        alert('자리 정보 Successful!')
        this.$store.state.seatdata = res.data
        this.seatRow = ''
        this.seatCol = ''
        } 
        else { 
          alert('자리 불러오기 실패')
        }
      })*/
    },

    check(curseat,event){
      const { seatNo } = this.seatInfo
        //여기서 나갈값과 정보 받아올때 다시 정하기
      axios.post(`http://localhost:7777/reservation/pickedSeats`, {seatNo})

        .then(res => {

          let th=this

          this.current = res.data
          this.$store.state.seatdata = res.data

          if (event.currentTarget.style.background == "plum") {
            event.currentTarget.style = "background:";
            this.seatdata.pop()

            // let idx = this.selectedSeat.indexOf(seatNum);
            // this.selectSeats.splice(idx, 1);

          } else if(event.currentTarget.style.background != "red"){
            event.currentTarget.style = "background:plum";
            this.seatdata.push(curseat)
          }
        
          console.log(this.curseat)

          let seatflag=0

          for(var i=0;i<th.selectedSeat.length;++i){
            if(curseat == th.selectedSeat[i]){
              console.log("중복")
              alert('이미 선택된 좌석입니다.다른 자리 선택하세요')  
              seatflag=1;
            }
          }
          if(seatflag==1){
            this.seatdata.pop()
          }
        })          
    },    
  },
  test(seatNum) {
      console.log(seatNum);
      this.seatsInfo = this.seatsInfo + " " + seatNum;
     console.log(this.seatsInfo);     
    }
 }
</script>-->
<!--   // 여기서부터 주석
<template>

  <v-container class="place" justify="center">
      
    <v-row justify="center">
      <v-col cols="8" class="label" style="font-size:20pt">Libarary Seat Booking</v-col>            
    </v-row>
    
    <v-row justify="center">
      <v-col cols="2" class="label">userId</v-col>
      <v-col>
        <v-text-field rounded style="width:100px" readonly :value="this.userId"/>
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
        <div class="llabel">selected seat : {{this.seatdata}} </div>
      </v-col>
    </v-row>
      
    <v-row>
      <v-col>
        <table class="container ml-3" >
          <tbody >
            <tr v-for="(i, idx) in seatRows" :key="idx">
              <td v-for="(j, idx) in seatCols" :key="idx" >
                <button @click="check(String(i)+String(j), $event)"
                  v-bind:id="i + j"
                  v-bind:ref= "i + j" 
                  class="seat">
                  {{ i }}-{{ j }}
                </button>
                ----------<button @click="check(apblist[i]+j, $event)"
                  v-bind:id="apblist[i]+j"
                  v-bind:ref= "i + j" 
                  class="seat">
                  {{ apblist[i] }}{{ j }}
                  +'-'+
                </button>---------
              </td>
            </tr>
          </tbody>
        </table>
      </v-col>
    </v-row>  
  
    <v-row>
      <v-btn type="submit" @click="selectSeatBtn()" class="selectSeatBtn" dark > select</v-btn>
    </v-row>
        ------- 주석
          <router-link :to="{name: 'ReservationPage', params: {run_id: $route.params.run_id, seat:seatdata}}">
            선택완료
          </router-link>---------여기서 다시 주석   
  </v-container>
</template>

<script>

import axios from "axios";

export default {
  
   name:'ReservationSeatForm',

  data(){
    return{
      current:null,
      seatRows:3,
      seatCols:5,
      redseat:[],
      apblist:['','A','B','C','D','E','F','G','H'],
      seatdata:[],
      seatNum:""
      //row:"",
      //col:""
      //일단 해결해야 되는 것은payload에 값이 안들어감
      //seatRow에 3이 이미 정해져 있어서 그런것이 아닐까 생각함
      
    }
  },
  created(){ 
    this.userId = this.$store.state.session.userId;  
    this.seatdata = this.$store.state.seatdata;
    this.getSeatdata();
    this.seatNum= this.$store.state.seatdata;
  },
  mounted(seatdata){
   
    axios.get(`http://localhost:7777/reservation/pickedSeats`,{seatdata})    
      .then(res => {
        console.log(res.data)
        for( var iii=0; iii < res.data.length; ++iii){
          this.redseat.push(res.data[iii].seatdata)
        }
        console.log(this.redseat)
      })
      .catch(() => {
         alert('마운트 자리 정보 문제 발생!')
        });
    for(var ii=0; ii < this.redseat.length; ++ii){
        document.getElementById(this.redseat[ii]).style = "background:black"
    }
  },

  methods: {
    getSeatdata(payload) {

      const{seatNum}=payload

      axios.get(`http://localhost:7777/reservation/pickedSeats`,{seatNum})
        .then(res => {
          //this.restSeats = response.data.restSeats;
          //console.log(this.restSeats);
          
          this.seatRows = res.data.seatRows;
          this.seatCols = res.data.seatCols;
        });
    },
   
    //좌석 선택을 눌렀을 때 이벤트 발생
    check(curseat, event){   

      if (event.currentTarget.style.background == "goldenrod") {

        event.currentTarget.style = "background:";

        this.seatdata.pop()
        
      } 
      else if(event.currentTarget.style.background != "black"){

        event.currentTarget.style = "background:goldenrod";
        this.seatdata.push(curseat)    
      }

      console.log(curseat)

      let seatflag=0
      for(var i=0;i<this.redseat.length;++i){
        if(curseat == this.redseat[i]){

          alert('이미 선택된 좌석입니다.다른 자리 선택하세요')  
          seatflag=1;
        }
      }
      if(seatflag == 1 ){
        this.seatdata.pop()
      }         
    },

    selectSeatBtn(payload) {
      const { seatRow,seatCol,seatNum} = payload
           
    //for(var s=0; s<this.$route.params.seatdata.length;++s){
      
      //seatNum = this.$route.params.seatdata[s]
        
       //const {seatNum}
        axios.post(`http://localhost:7777/reservation/makeReservation`, { seatRow,seatCol,seatNum})
        .then((res) => {
          alert('자리 정보 날아감')
          console.log(res);
          this.seatRow = ''
          this.seatCol = ''
          this.seatNum=''
        })
        .catch(() => {
         alert('자리 정보 문제 발생!')
        });
        
    },

    getSeat(seatRow,seatCol){
      axios.get(`http://localhost:7777/reservation/getSeat`,{seatRow,seatCol})
      .then(res => {
        console.log(res.data)
        this.seatRow = res.data.seatRow
        this.seatCol = res.data.seatCol
      })
      .catch(() => {
         alert('자리 정보 문제 발생!')
        });
    }
    }
     /*
    sign(){
      axios.get(`http://localhost:7777/reservation/pickedSeats`)
      .then(res => {
        console.log(res); 
        this.current = res.data
      });
    },
    {
        const { seatdata } 
      axios.get(`http://localhost:8080/reservation/getSeat`,{seatdata})
      .then((res) => {
        console.log("야야야야야")
       
        this.seatRow=res.data[0].seatRow
        this.seatCol=res.data[0].seatCol
        console.log(this.seatRow)
      })
      .catch(() => {
         alert('리턴 값 자리 정보 문제 발생!')
        })},*/

  // params: {
  //movie_ROOM_NUM:this.$route.params.roomnum,  

    
}
    

</script>

<style scoped>

@import url("https://fonts.googleapis.com/css?family=Lato&display=swap");


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

</style>-->

<template>

  <v-container class="place" justify="center">
      
    <v-row justify="center">
      <v-col cols="8" class="label" style="font-size:20pt">Libarary Seat Booking</v-col>            
    </v-row>
    
    <v-row justify="center">
      <v-col cols="2" class="label">userId</v-col>
      <v-col>
        <v-text-field rounded style="width:100px" readonly :value="this.userId"/>
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
        <div class="llabel">selected seat : {{this.seatdata}} </div>
      </v-col>
    </v-row>
      
    <v-row>
      <v-col>
        <table class="container ml-3" >
          <tbody >
            <tr v-for="(i, idx) in seatRows" :key="idx">
              <td v-for="(j, idx) in seatCols" :key="idx" >
                <button @click="check(String(i)+String(j), $event)"
                  v-bind:id="i + j"
                  v-bind:ref= "i + j" 
                  class="seat">
                  {{ i }}-{{ j }}
                </button>
                <!--<button @click="check(apblist[i]+j, $event)"
                  v-bind:id="apblist[i]+j"
                  v-bind:ref= "i + j" 
                  class="seat">
                  {{ apblist[i] }}{{ j }}
                  +'-'+
                </button>-->
              </td>
            </tr>
          </tbody>
        </table>
      </v-col>
    </v-row>  
  
    <v-row>
      <v-btn type="submit" class="selectSeatBtn" dark > select</v-btn>
    </v-row>
        <!-- 주석
          <router-link :to="{name: 'ReservationPage', params: {run_id: $route.params.run_id, seat:seatdata}}">
            선택완료
          </router-link>---------여기서 다시 주석-->   
  </v-container>
</template>

<script>

import axios from "axios";

export default {
  
   name:'ReservationSeatForm',

  data(){
    return{
      current:null,
      seatRows:3,
      seatCols:5,
      soldseat:[],
      apblist:['','A','B','C','D','E','F','G','H'],
      seatdata:[],
      seatNum:[],
      
    }
  },
  created(){ 
    //일단 여기에는 예약된 자리들을 다 불러오면 됨(repositpory.findall로 다가져오기)
    this.userId = this.$store.state.session.userId;   
  },
  mounted(seatdata){//일단 seatdata를 넣은 것도 이상하고 mounted도 이상함
   
    axios.get(`http://localhost:7777/reservation/pickedSeats`,{seatdata})    
      .then(res => {
        console.log(res.data)
        for( var iii=0; iii < res.data.length; ++iii){
          this.soldseat.push(res.data[iii].seatdata)
        }
        console.log(this.soldseat)
      })
      .catch(() => {
         alert('마운트 자리 정보 문제 발생!')
        });
    for(var ii=0; ii < this.soldseat.length; ++ii){
        document.getElementById(this.soldseat[ii]).style = "background:black"
    }
  },

  methods: {
    getSeatdata(payload) {

      const{ seatNum }=payload

      axios.get(`http://localhost:7777/reservation/pickedSeats`,{ seatNum })
        .then(res => {
          //this.restSeats = response.data.restSeats;
          //console.log(this.restSeats);
          
          this.seatRows = res.data.seatRows;
          this.seatCols = res.data.seatCols;
        });
    },
   
    //자리 버튼을 눌렀을 때 이벤트 발생
    check(curseat, event){   

      if (event.currentTarget.style.background == "goldenrod") {

        event.currentTarget.style = "background:";

        this.seatdata.pop()
        
      } 
      else if(event.currentTarget.style.background != "black"){

        event.currentTarget.style = "background:goldenrod";
        this.seatdata.push(curseat) 

        this.seatdata = curseat;
        this.seatNum = curseat;   
      }

      console.log(curseat)

      let seatflag=0
      for(var i=0;i<this.redseat.length;++i){
        if(curseat == this.redseat[i]){

          alert('이미 선택된 좌석입니다.다른 자리 선택하세요')  
          seatflag=1;
        }
      }
      if(seatflag == 1 ){
        this.seatdata.pop()
      }         
    },

    getSeat(seatRow,seatCol){
      axios.get(`http://localhost:7777/reservation/getSeat`,{seatRow,seatCol})
      .then(res => {
        console.log(res.data)
        this.seatRow = res.data.seatRow
        this.seatCol = res.data.seatCol
      })
      .catch(() => {
         alert('자리 정보 문제 발생!')
        });
    }
    }
     /*
    sign(){
      axios.get(`http://localhost:7777/reservation/pickedSeats`)
      .then(res => {
        console.log(res); 
        this.current = res.data
      });
    },
    {
        const { seatdata } 
      axios.get(`http://localhost:8080/reservation/getSeat`,{seatdata})
      .then((res) => {
        console.log("야야야야야")
       
        this.seatRow=res.data[0].seatRow
        this.seatCol=res.data[0].seatCol
        console.log(this.seatRow)
      })
      .catch(() => {
         alert('리턴 값 자리 정보 문제 발생!')
        })},*/

  // params: {
  //movie_ROOM_NUM:this.$route.params.roomnum,  

    
}
    

</script>

<style scoped>

@import url("https://fonts.googleapis.com/css?family=Lato&display=swap");


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



