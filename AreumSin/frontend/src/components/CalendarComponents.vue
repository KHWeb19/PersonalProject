<template>
  <v-container>
    <v-row>
      <v-col align="start" align-self="center">
        <v-btn @click="prev">
          <v-icon> mdi-chevron-left</v-icon>
        </v-btn>
      </v-col>
      <v-col class="calendar-today" align="center">
        <h3>{{ year }}</h3>
        <h2>{{ month }}월</h2>
      </v-col>
      <v-col align="end" align-self="center">
        <v-btn @click="next">
          <v-icon> mdi-chevron-right</v-icon>
        </v-btn>
      </v-col>
    </v-row>

    <v-row class="calendar-title">
     <v-col align="center" v-for="day in days" :key="day">{{day}}</v-col>
    </v-row>

    <v-row v-for="(date, idx) in dates" :key="idx">
      <v-col class="calendar-days" style="height: 100px; width: 100px" v-for="(day, secondIdx) in date" :key="secondIdx" v-on:mouseup.left="doMouseOver">{{day}}</v-col>
      </v-row>
  </v-container>
</template>

<script>
export default {
  name: "CalendarComponents",
  data() {
    return{
      year: 0,
      month: 0,
      days: [
          'Sun',
          'Mon',
          'Tue',
          'Wed',
          'Thu',
          'Fri',
          'Sat',
      ],
      dates: [],
      currentYear: 0,
      currentMonth: 0,
      lastMonthDay: [],
      nextMonthDay: []
    }
  },
  created() {
    const date = new Date();

    this.year = date.getFullYear(); //연도(네 자릿수)를 반환
    this.month = date.getMonth() +1; //월을 반환 (0 이상 11 이하)
    this.calendarData();
  },
  methods: {
    doMouseOver(){
      alert('로그인 확인 후에 눌렀다!')
    },
    prev() {
      if(this.month !== 1){
        this.month = this.month -1;
      }else if(this.month ===1){
        this.month = 12;
        this.year = this.year-1;
      }
      this.calendarData()
      // alert(+" "+this.month)
    },
    next(){
      if(this.month !== 12){
        this.month = this.month +1;
      }else{
        this.month = 1;
        this.year = this.year +1;
      }
      this.calendarData()
    },
    calendarData() {
      const [monthFirstDay, monthLastDate, lastMonthLastDate] = this.getFirstDayLastDate(this.year, this.month);
      this.dates = this.getMonthOfDays(monthFirstDay, monthLastDate, lastMonthLastDate);
    },
    getFirstDayLastDate(year, month) {
      const firstDay = new Date(year, month - 1, 1).getDay(); // 저번달 마지막 요일 getDay (0~ 6) 일~ 토
      const lastDate = new Date(year, month, 0).getDate(); // (1 ~ 31) 마지막 날
      let lastYear = year;
      let lastMonth = month - 1;

      if (month === 1) {
        lastMonth = 12;
        lastYear -= 1;
      }

      const prevLastDate = new Date(lastYear, lastMonth, 0).getDate(); // 지난 달 마지막 날짜
      return [firstDay, lastDate, prevLastDate]; // 1(월요일), 31, 28
    },
    getMonthOfDays(monthFirstDay, monthLastDate, prevMonthLastDate) {
      let day = 1;
      let prevDay = (prevMonthLastDate - monthFirstDay) + 1;
      const dates = [];
      let weekOfDays = [];
      while (day <= monthLastDate) {
        if (day === 1) {
          for (let j = 0; j < monthFirstDay; j += 1) {
            weekOfDays.push(prevDay);
            prevDay += 1;
          }
        }
        weekOfDays.push(day);
        if (weekOfDays.length === 7) {
          // 일주일 채우면
          dates.push(weekOfDays);
          weekOfDays = []; // 초기화
        }
        day += 1;
      }
      const len = weekOfDays.length;
      if (len > 0 && len < 7) {
        for (let k = 1; k <= 7 - len; k += 1) {
          weekOfDays.push(k);
        }
      }
      if (weekOfDays.length > 0) dates.push(weekOfDays); // 남은 날짜 추가
      return dates;
    },
  },
}
</script>

<style scoped>
.calendar-today{
  color: #08080e;
}
.calendar-title{
  place-items: center;
  color: #485152;
}
.calendar-days{
  width: 50px;
  height: 50px;
  display: grid;
  border: solid 1px black;
}

.calendar-days:hover {
  color: blue;

}
</style>