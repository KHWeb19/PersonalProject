<template>
  <v-container>
    <MainCategory></MainCategory>

    <v-row>
      <v-col cols="3">
      <MenuList></MenuList>
      </v-col>
      <v-col cols="9">
        <v-card style="margin-top: 10px; height: 880px" class="pa-4">
          <MemberManage :myPage="myPage"></MemberManage>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>

import MainCategory from "@/components/MainCategory";
import MenuList from "@/components/Item/MenuList";
import {mapActions, mapState} from "vuex";
import MemberManage from "@/components/myPage/MemberManage";
export default {
  name: "MyPage",
  components: {MemberManage, MenuList, MainCategory},
  data(){
    return{
      user: localStorage.getItem("session"),
    }
  },
  computed: {
    ...mapState(['myPage'])
  },
  methods: {
    ...mapActions(['fetchUserInfo'])
  },
  mounted() {
    this.fetchUserInfo(this.user)
  }
}
</script>

<style scoped>

</style>