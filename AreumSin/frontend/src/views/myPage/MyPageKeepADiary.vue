<template>
  <v-container>
    <MainCategory></MainCategory>

    <v-row>
      <v-col cols="3">
        <MenuList></MenuList>
      </v-col>
      <v-col cols="9">
        <v-card style="margin-top: 10px; height: 880px" class="pa-4">
          <KeepADiary :userPlans="userPlans"></KeepADiary>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import MainCategory from "@/components/MainCategory";
import MenuList from "@/components/Item/MenuList";
import KeepADiary from "@/components/myPage/KeepADiary";
import {mapActions, mapState} from "vuex";
export default {
  name: "MyPageKeepADiary",
  components: {KeepADiary, MenuList, MainCategory},
  data(){
    return {
      user: localStorage.getItem("session")
    }
  },
  computed: {
    ...mapState(['userPlans'])
  },
  methods: {
    ...mapActions(['fetchUserPlans']),
  },
  mounted() {
    this.fetchUserPlans(this.user)
  }
}
</script>

<style scoped>

</style>