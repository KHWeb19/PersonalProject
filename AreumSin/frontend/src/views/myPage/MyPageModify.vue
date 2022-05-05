<template>
  <v-container>
    <MainCategory></MainCategory>

    <v-row>
      <v-col cols="3">
        <MenuList></MenuList>
      </v-col>
      <v-col cols="9">
        <v-card style="margin-top: 10px; height: 880px" class="pa-4">
          :)
          <MemberManageModify :my-page="myPage" @modify="modify"></MemberManageModify>
        </v-card>
      </v-col>
    </v-row>

  </v-container>
</template>

<script>

import MainCategory from "@/components/MainCategory";
import MenuList from "@/components/Item/MenuList";
import {mapActions, mapState} from "vuex";
import MemberManageModify from "@/components/myPage/MemberManageModify";
import axios from "axios";

export default {
  name: "MyPageModify",
  components: {MemberManageModify, MenuList, MainCategory},
  computed: {
    ...mapState(['myPage'])
  },
  data(){
    return{
      user: localStorage.getItem("session")
    }
  },
  methods: {
    ...mapActions(['fetchUserInfo']),
    modify(payload){
      const {pw, name, birth, color} = payload
      let id = this.myPage.id

      //alert(id+", "+ name)

      axios.put(`http://localhost:7777/myPage/${this.user}`, {id, pw, name, birth, color})
        .then(() => {
          //alert('수정 성공' + res)
          this.$router.push({name: 'MyPage'});
        })
    }
  },
  mounted() {
    this.fetchUserInfo(this.user)
  }
}
</script>

<style scoped>

</style>