<template>
    <div>
        <main-form/>
        <date-appointment v-if="doctor" :doctor="doctor" @submit="onSubmit"/><br><br>
        <main-bottom/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import MainForm from '@/components/main/MainForm.vue'
import DateAppointment from '@/components/ap/DateAppointment.vue'
import MainBottom from '@/components/main/MainBottom.vue'
import axios from 'axios'
export default {
  name: 'DateAppointmentPage',
  components: {
    MainForm,
    DateAppointment,
    MainBottom
  },
  props: {
    doctorNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['doctor'])
  },
  created () {
    this.fetchDoctor(this.doctorNo)
      .catch(() => {
        alert('게시물 요청 실패')
        this.$router.back()
      })
  },
  methods: {
    ...mapActions(['fetchDoctor']),
    onSubmit (payload) {
      const { date, time, memberNo } = payload
      axios.post('http://localhost:7777/appointment/register',
        { date, time, memberNo, doctorNo: this.doctor.doctorNo })
        .then(() => {
          alert('예약 성공')
        })
        .catch(() => {
          alert('문제 발생')
        })
    }
  }
}
</script>
