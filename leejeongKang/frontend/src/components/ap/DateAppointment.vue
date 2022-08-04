<template>
    <body>
      <v-container>
      <form @submit.prevent="onSubmit">
      <v-col>
        <v-row justify="center">
          <v-card class="pa-4">
            <v-subheader style="dark">의사 정보</v-subheader>
               <v-divider :inset="false"></v-divider>
                <v-col cols="12">
                  <v-text-field :value="this.$store.state.doctor.major" label="진료과" type="text" readonly></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field :value="this.$store.state.doctor.doctorName" label="이름" type="text" readonly></v-text-field>
                </v-col>
          </v-card>
          <v-card class="pa-4">
            <v-subheader style="dark">예약자 정보</v-subheader>
               <v-divider :inset="false"></v-divider>
                <v-col cols="12">
                  <v-text-field :value="this.$store.state.userInfo.name" label="이름" type="text" readonly></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field :value="this.$store.state.userInfo.birth" label="생년월일" type="text" readonly></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field :value="this.$store.state.userInfo.phone" label="연락처" type="text" readonly></v-text-field>
                </v-col>
          </v-card>
          <v-card class="pa-5">
            <v-subheader style="dark">예약 날짜</v-subheader>
               <v-divider :inset="false"></v-divider>
                <v-col cols="12">
                  <v-date-picker class="datepicker"
                  locale="ko-KR"
                  max="max"
                  :allowed-dates="disablePastDates"
                   v-model="date" type="date"></v-date-picker><br>
                </v-col>
                <v-col cols="12">
                  <v-select :items="timeSelect" label="시간" v-model="time" required></v-select>
                </v-col>
                <div id ='btn'>
            <v-btn class="white--text" id="BtnAtpt" type="submit">예약하기</v-btn>
          </div>
          </v-card>
        </v-row>
      </v-col>

    </form>
  </v-container>
</body>
</template>

<script>
const now = new Date() // 현재 시간
const utcNow = now.getTime() + (now.getTimezoneOffset() * 60 * 1000) // 현재 시간을 utc로 변환한 밀리세컨드값
const koreaTimeDiff = 9 * 60 * 60 * 1000 // 한국 시간은 UTC보다 9시간 빠름(9시간의 밀리세컨드 표현)
const koreaNow = new Date(utcNow + koreaTimeDiff)
const maxDate = new Date(koreaNow + 30)
export default {
  name: 'DateAppointmentPage',
  props: {
    doctor: {
      type: Object,
      required: true
    },
    userInfo: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      date: '',
      max: maxDate,
      time: '',
      timeSelect: ['9:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00'],
      memberNo: this.$store.state.userInfo.memberNo
    }
  },
  methods: {
    disablePastDates (val) {
      return val >= koreaNow.toISOString()
    },
    onSubmit () {
      const { date, time, memberNo } = this
      this.$emit('submit', { date, time, memberNo })
    }
  }
}
</script>

<style scoped>
h2 { font-size: 30px;}
#contents { text-align: center; }
#btn { text-align: center; font-size: 20px; }
#BtnAtpt { background-color: navy; width: 350px; height: 55px;}
.datepicker { width: 350px; height: 450px;}
.pa-4 { width: 300px; }
.pa-5 { width: 400px; }
</style>
