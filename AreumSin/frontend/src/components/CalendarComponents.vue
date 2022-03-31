<template>
  <v-container>
    <v-row>
      <v-col align="start" align-self="center">
        <v-btn @click="prev(month, year)">
          <v-icon> mdi-chevron-left</v-icon>
        </v-btn>
      </v-col>
      <v-col class="calendar-today" align="center">
        <h3>{{ year }}</h3>
        <h2>{{ month }}월</h2>
      </v-col>
      <v-col align="end" align-self="center">
        <v-btn @click="next(month, year)">
          <v-icon> mdi-chevron-right</v-icon>
        </v-btn>
      </v-col>
    </v-row>

    <v-row class="calendar-title">
     <v-col align="center" style="border: solid 1px black;" v-for="day in days" :key="day">{{day}}</v-col>
    </v-row>

    <v-row v-for="(date, idx) in dates" :key="idx" class="calendar-days">
      <v-col class="calendar-days" style="border: solid 1px black;" v-for="(day, secondIdx) in lastMonthDay" :key="secondIdx">{{day}}</v-col>
      <v-col class="calendar-days" style="border: solid 1px black;" v-for="(day, secondIdx) in date" :key="secondIdx">{{day}}</v-col>
      <v-col class="calendar-days" style="border: solid 1px black;" v-for="(day, secondIdx) in nextMonthDay" :key="secondIdx">{{day}}</v-col>
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
    this.calendarData(this.year, this.month);
  },
  methods: {
    prev(month, year) {
      if(month !== 1){
        this.month = month -1;
      }else{
        this.month = 12;
        this.year = year -1;
      }
      this.calendarData(this.year, this.month-1)
    },
    next(month, year){
      if(month !== 12){
        this.month = month +1;
      }else{
        this.month = 1;
        this.year = year +1;
      }
      this.calendarData(this.year, this.month+1)
    },
    calendarData(year, month) {
      const [monthFirstDay, monthLastDate, lastMonthLastDate] = this.getFirstDayLastDate(year, month);
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
      let prevDay = (prevMonthLastDate - monthFirstDay) + 1; // 28
      const dates = [];
      let lastMonthDay = [];
      let weekOfDays = [];
      let nextMonthDay = [];
      while (day <= monthLastDate) { /// day <= 31
        if (day === 1) {
          // 1일이 어느 요일인지에 따라 테이블에 그리기 위한 지난 셀의 날짜들을 구할 필요가 있다.
          for (let j = 0; j < monthFirstDay; j += 1) { // 여기서 저번달 보여줌. 2일정도
            lastMonthDay.push(prevDay);
            prevDay += 1;
          }
          this.lastMonthDay = lastMonthDay;
        }
        weekOfDays.push(day);

        day += 1;
      }
      const len = weekOfDays.length + lastMonthDay.length;
      if (len % 7 !== 0) {
        //let num = len % 7;
        //let res = ((num+1)*7) - len;
        //alert(num)
        //nextMonthDay.push(res);
      }
      this.nextMonthDay = nextMonthDay;
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
  display: grid;
  grid-template-columns: repeat(7, 1fr);
  cursor: pointer;
}
</style>