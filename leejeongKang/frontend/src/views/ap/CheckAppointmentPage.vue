<template>
<div id="appointment">
  <main-form/>
  <check-appointment :appointments="appointments"/>
  <main-bottom/>
</div>
</template>

<script>
import CheckAppointment from '@/components/ap/CheckAppointment.vue'
import MainForm from '@/components/main/MainForm.vue'
import MainBottom from '@/components/main/MainBottom.vue'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'CheckAppointmentPage',
  components: {
    CheckAppointment,
    MainForm,
    MainBottom
  },
  props: {
    memberNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['appointments'])
  },
  created () {
    this.fetchAppointmentList(this.$store.userInfo.memberNo)
      .catch(() => {
        alert('요청 실패')
      })
  },
  mounted () {
    this.fetchAppointmentList()
  },
  methods: {
    ...mapActions(['fetchAppointmentList'])
  }
}
</script>
