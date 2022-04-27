<template>

       <div>
            <reservation-seat-form @submit="onSubmit"/>   
        </div>
  
    
</template>

<script>

import ReservationSeatForm from '@/components/board/reservation/ReservationSeatForm.vue'
import axios from 'axios'


export default {
    name:'ReservationPage',

    data () {
        return {
        current:null,
        seatRows:0,
        seatCols:0,
        seatdata:[],
        seatNum:""
             
        }
    },

    components:{
        ReservationSeatForm
    },

    created(){
        this.seatdata = this.$store.state.seatdata;
    },
     methods: {


    onSubmit(payload) {

      const {seatNum}=payload

    //for(var s=0; s<this.$route.params.seatdata.length;++s){
    //seatNum = this.$route.params.seatdata[s]
        
        axios.post(`http://localhost:7777/reservation/makeReservation`, { seatNum })
        .then(() => {
          alert('자리 정보 날아감')
          //console.log(res);
          //this.seatRow = ''
          //this.seatCol = ''
          //this.seatNum=''
        })
        .catch(() => {
         alert('자리 정보 문제 발생!')
        });
    }
        
    },


      
    }
    

</script>
     