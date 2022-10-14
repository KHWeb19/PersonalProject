<template>
    <div>
      <main-form/>
        <doctor-read v-if="doctor" :doctor="doctor"></doctor-read>
        <p v-else>로딩중 .......</p><br><br><br>
        <main-bottom/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import DoctorRead from '@/components/ap/DoctorRead.vue'
import MainForm from '@/components/main/MainForm.vue'
import MainBottom from '@/components/main/MainBottom.vue'
export default {
  name: 'DoctorReadPage',
  components: {
    DoctorRead,
    MainForm,
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
    ...mapActions(['fetchDoctor'])
  }
}
</script>

<style scoped>
#menu { text-align: center; }
a { text-decoration: none; font-size: 18px; }
</style>
