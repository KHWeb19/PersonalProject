<template>
    <div id ="doctor">
        <main-form/>
        <depart-list :doctors="doctors"/>
        <main-bottom/>
    </div>
</template>

<script>
import MainForm from '@/components/main/MainForm.vue'
import DepartList from '@/components/ap/DepartList.vue'
import MainBottom from '@/components/main/MainBottom.vue'
import { mapActions, mapState } from 'vuex'

export default {
  name: "DepartListPage.vue",
  components: {
    DepartList,
    MainForm,
    MainBottom
  },
  computed: {
    ...mapState(['doctors'])
  },
  mounted () {
    this.fetchDoctorList()
  },
  methods: {
    ...mapActions(['fetchDoctorList'])
  }
}
</script>
