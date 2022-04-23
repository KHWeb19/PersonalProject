<template>
  <v-container>
    <v-card>
      <v-row class="pa-5" style="height: 300px" v-for="(idx) in n" :key="idx" id="calendar-day-row">
        <v-col v-for="(idx2) in 4" :key="idx2" style="border: black solid 1px" id="calendar-day" @click="test(idx, idx2)">{{dates[idx][idx2]}}</v-col>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "PlanPage",
  props: {
    days:{
      type: Number,
      required: true
    },

  },
  data(){
    return{
      index: 0,
      data: '',
      currentPage: 1,
      n: 0,
      startMonth: localStorage.getItem('startMonth'), // 4
      firstDay: localStorage.getItem('firstDay'),// 20
      lastDay: localStorage.getItem('lastDay'), // 23
      lastMonthDay: localStorage.getItem('lastMonthDay'), // 30
      monthDay: localStorage.getItem('monthDay'), // 0
      dates: [],
    }
  },
  created() {
    this.calendarData();
  },
  methods:{
    test(index1, index2) {
      alert(this.dates[index1][index2])
      this.day = this.dates[index1][index2];
      this.$router.push({name: 'PlanDayView', params: {day: this.day.toString()}})
    },
    calendarData() {
      this.dates = this.getMonthOfDays(this.startMonth, this.firstDay, this.lastDay, this.lastMonthDay, this.monthDay); // 4, 20, 23, 30, 0
    },
    checkLastDay(month){
      let lastDay;
      switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
          lastDay = 31;
          break;

        case 2:
          lastDay = 28;
          break;

        default:
          lastDay = 30;
          break;
      }

      return lastDay;
    },
    getMonthOfDays(startMonth, monthFirstDay, prevMonthLastDate, monthLastDate, monthDay) {// 4, 20, 23, 30, 0

      let day = prevMonthLastDate > monthFirstDay ? prevMonthLastDate - monthFirstDay +1 : monthFirstDay - prevMonthLastDate +1
      let startDay = monthFirstDay; // 20

      const dates = [];

      if(this.month > 0) {
        //console.log("아직 안들어옴")
        for(let i = 0; i < monthLastDate; i++, startDay++){
          console.log(startDay)
          dates.push(startDay)
        }

        for(let i = 0;  i< monthDay; i++){
          let lastDay = this.checkLastDay(startMonth+1)

          for(let j = 1; j <= lastDay; j++){
            dates.push(j);
          }
        }

        for(let i = 0; i < prevMonthLastDate; i++){
          dates.push(i);
        }
      }else {
        for(let i = 0; i < day; i++, startDay++){
          console.log(startDay)
          dates.push(startDay)
        }

        console.log(dates.length)
      }

      let div = dates.length / 4;
      let remain = dates.length % 4;
      let n;

      if(remain === 0 && div < 0){
        n = div +1;
      }else if(remain === 0){
        n = div;
      }else{
        n = div +1;
      }

      this.n = n

      console.log('n: '+n);

      let date = new Array(n+1);

      for(let i = 1; i < 5; i++){
        date[i] = new Array(i);
      }

      let k = 0;
      for(let i = 1;  i <= n+1; i++){
        for(let j = 1;  j <= 4; j++){
          date[i][j] = dates[k];
          k++;
        }
        console.log(date[i])
      }

/*      if(dates.length % 4 === 0){
        console.log(dates.length % 4);
      }else{
        for(let i = 0; i < dates.length % 4; i++){
          dates.push(' ');
        }
      }*/ // 구현은 제대로 되었으나 생각보다 이상함..

      return date;
    },
  },
  computed:{


  }
}
</script>

<style scoped>
td{
  padding-bottom: 150px;
  padding-right: 40px;
}
#calendar-day{
  display: grid;
  gap: 2px;
  color: pink;
}
</style>