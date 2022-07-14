<template>
  <div align="center" class="member-box">
    <v-row style="margin-top: 8%">
      <h4><b>회원명</b> {{ user.userName }}</h4>
    </v-row>
    <v-row>
      <h4><b>아이디</b> {{ user.userId }}</h4>
    </v-row>
    <v-row>
      <h4><b>전화번호</b> {{ user.userPhone }}</h4>
    </v-row>

    <div>
      <v-flex xs4 sm10 md12>
        <v-btn
          class="modify"
          text
          outlined
          color="blue lighten-1"
          route
          :to="{ name: 'UserReadPage', params: { memberNo: user.memberNo } }"
          >회원정보수정</v-btn
        >
        <v-layout class="delete">
          <v-dialog v-model="dialog" persistent max-width="400px">
            <template v-slot:activator="{ on }">
              <v-btn
                plain
                color="blue lighten-1"
                v-on="on"
                style="margin-top: 7%"
                >계정을 삭제하겠습니다</v-btn
              >
            </template>

            <v-card>
              <v-toolbar color="white darken-3" flat height="50">
                <v-btn text x-large class="exit" @click="cancle()">
                  <v-icon>clear</v-icon>
                </v-btn>
              </v-toolbar>
              <v-card-text>
                계정을 삭제하시겠습니까?<br />
                삭제 시 서비스의 제한이 있을 수 있습니다.
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn text color="blue darken-1" @click="onDelete()" outlined>
                  확인
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-layout>
      </v-flex>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import cookies from "vue-cookies";
import { LOGOUT } from "@/store/mutation-types";
export default {
  name: "UserListForm",
  props: {
    user: {
      authList: Array,
      password: String,
      userId: String,
      userName: String,
      userPhone: String,
      memberNo: Number,
    },
  },
  data() {
    return {
      dialog: false,
    };
  },
  methods: {
    cancle() {
      this.dialog = false;
    },
    onDelete() {
      const { memberNo } = this.user;
      axios
        .delete(`http://localhost:7777/jpaMember/${memberNo}`)
        .then(() => {
          alert("계정을 삭제했습니다.");
          this.dialog = false;
          this.$router.push({ name: "MainPage" });
          this.$store.state.user = null;
          cookies.remove("user");
          this.$store.commit(LOGOUT);
        })
        .catch((res) => {
          alert(res.response.data.message);
        });
    },
  },
};
</script>

<style scoped>
h4 {
  margin-top: 0px;
  font-family: "Nanum Myeongjo";
  font-size: 18px;
  margin-left: 40%;
}
.member-box {
  margin-top: 2%;
}
.exit {
  position: relative;
  left: 85%;
}
.delete {
  position: relative;
  left: 80%;
}
.modify {
  margin-top: 5%;
}
</style>