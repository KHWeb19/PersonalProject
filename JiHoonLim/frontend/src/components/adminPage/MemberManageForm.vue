<template>
  <div class="grey lighten-3" style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1240px">
      <v-row class="orange lighten-5">
        <v-col>
          <div class="main_tit_box">공지사항</div>
        </v-col>
      </v-row>
      <v-row justify="center">
        <v-col>
          <div style="countWrap">
            총
            <b class="count">{{ registerMembers.length }}</b
            >명의 회원이 있습니다.
          </div>
        </v-col>
      </v-row>
      <v-row>
        <v-col v-for="(registerMember, index) in registerMembers" :key="index">
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "MemberManagerForm",
  props: {
    registerMembers: {
      type: Array,
    },
  },
};
</script>

<style scoped>
.main_tit_box {
  text-align: left;
  font-size: 35px;
  color: #333;
  padding: 8px 0 8px 0;
  font-style: italic;
  position: relative;
}
.count {
  font-size: 36px;
  color: orange;
}
.countWrap {
  font-size: 16px;
  color: #333;
  padding: 5px 0 20px 8px;
}
</style>
