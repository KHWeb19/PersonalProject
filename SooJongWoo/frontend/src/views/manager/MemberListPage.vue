<template>
  <div id="member" class="img">
    <menu-bar />
    <v-card class="card-box">
      <v-navigation-drawer permanent style="float: left">
        <v-list>
          <v-list-item link>
            <v-list-item-content>
              <v-list-item-title class="text-h6">
                {{ userId }}
              </v-list-item-title>
              <v-list-item-subtitle>관리자님, 환영합니다.</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-divider></v-divider>

        <v-list nav dense>
          <v-list-item route :to="{ name: 'MemberListPage' }">
            <v-list-item-icon>
              <v-icon>mdi-account</v-icon>
            </v-list-item-icon>
            <v-list-item-title>회원목록관리</v-list-item-title>
          </v-list-item>
          <v-list-item route :to="{ name: 'BookingListPage' }">
            <v-list-item-icon>
              <v-icon>mdi-book</v-icon>
            </v-list-item-icon>
            <v-list-item-title>예약내역관리</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>

      <div class="user-info">
        <v-card max-height="555" class="scroll" flat>
          <v-row justify="center" style="margin: 3%">
            <h4 style="margin-top: 5%">회원목록</h4>
          </v-row>
          <member-list
            :members="members"
            :memberAuths="memberAuths"
            class="table-box"
          />
        </v-card>
      </div>
    </v-card>
    <div class="container" style="margin-bottom: 2%" v-if="cookie == false">
      <div>
        <v-row justify="center" style="margin: 10% auto">
          <h4 style="margin-top: 5%; color: white">
            로그인 시간이 초과되었습니다.
          </h4>
        </v-row>
      </div>
    </div>
  </div>
</template>

<script>
import MenuBar from "@/views/MenuBar.vue";
import MemberList from "@/components/manager/MemberList.vue";
import { mapState, mapActions } from "vuex";
export default {
  name: "MemberListPage",
  components: {
    MemberList,
    MenuBar,
  },
  data() {
    return {
      cookie: this.$cookies.isKey("user"),
      userId: this.$cookies.get("user"),
    };
  },
  computed: {
    ...mapState(["members", "memberAuths"]),
  },
  mounted() {
    this.fetchMemberList(), this.fetchMemberAuthList();
  },
  methods: {
    ...mapActions(["fetchMemberList", "fetchMemberAuthList"]),
  },
};
</script>

<style scoped>
h1 {
  font-size: 40px;
  text-align: center;
  margin-top: 5%;
  color: #fffffa;
  text-shadow: 4px 1px 8px #3b3b3b;
}
p {
  font-family: "Nanum Myeongjo";
  font-size: 24px;
  text-align: center;
  padding: 2vh 0vh 2vh 0vh;
  margin-bottom: 0px;
}
h4 {
  margin-top: 0px;
  font-family: "Gowun Batang";
  font-size: 25px;
}

.user-info {
  float: left;
  width: 78.9%;
}
.card-box {
  height: 80%;
  width: 80%;
  margin: 0 auto;
  justify-content: center;
  position: relative;
  top: 5%;
}
.img {
  position: relative;
  height: 100vh;
  background-size: cover;
}
</style>