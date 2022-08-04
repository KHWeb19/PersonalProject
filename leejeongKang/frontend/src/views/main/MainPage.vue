<template>
    <body>
      <main-form></main-form>
      <main-center/>
      <main-bottom/>
    </body>
</template>
<script>
import MainForm from '@/components/main/MainForm.vue'
import MainBottom from '@/components/main/MainBottom.vue'
import { mapActions, mapState } from 'vuex'
import MainCenter from '@/components/main/MainCenter.vue'
export default {
  name: "MainPage.vue",
  components: {
    MainForm,
    MainCenter,
    MainBottom
  },
  computed: {
    ...mapState(['member'])
  },
  mounted () {
    this.fetchMember()
  },
  methods: {
    ...mapActions(['fetchMember'])
  }
}
</script>

<style scoped>
#contents { padding: 15px; text-align: center; }
</style>
