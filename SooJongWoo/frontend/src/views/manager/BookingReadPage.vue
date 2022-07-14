<template>
  <div id="room" class="img">
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
        <v-row justify="center">
          <h4 style="margin-top: 4%">예약정보</h4>
        </v-row>
        <room-read v-if="room" :room="room" />
        <p v-else>로딩중 ......</p>

        <v-container class="justify center" style="padding: 0%">
          <v-row justify="center" align="center">
            <v-col cols="12" md="12">
              <v-btn
                color="blue"
                class="ma-2 white--text"
                route
                :to="{ name: 'BookingListPage' }"
              >
                목록보기
              </v-btn>

              <v-dialog v-model="dialog" persistent max-width="450">
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                    color="blue darken-2"
                    outlined
                    v-bind="attrs"
                    v-on="on"
                    class="ma-2 white--text"
                  >
                    예약 취소</v-btn
                  >
                </template>
                <v-card>
                  <v-card-title> 예약 삭제</v-card-title>
                  <v-card-text>
                    <br />
                    예약을 취소하시겠습니까?
                  </v-card-text>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="dialog = false"
                      >취소</v-btn
                    >
                    <v-btn color="blue darken-1" text @click="onDelete">
                      삭제
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
            </v-col>
          </v-row>
        </v-container>
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
import RoomRead from "@/components/manager/RoomRead.vue";
import { mapState, mapActions } from "vuex";
import axios from "axios";
export default {
  name: "BookingReadPage",
  components: {
    RoomRead,
    MenuBar,
  },
  data() {
    return {
      cookie: this.$cookies.isKey("user"),
      userId: this.$cookies.get("user"),
      dialog: false,
    };
  },
  props: {
    bookNo: {
      type: String,
      required: true,
    },
  },
  computed: {
    ...mapState(["room"]),
  },
  created() {
    this.fetchRoom(this.bookNo).catch((err) => {
      alert(err.response.data.message);
      this.$router.push();
    });
  },
  methods: {
    ...mapActions(["fetchRoom"]),
    onDelete() {
      const { bookNo } = this.room;
      axios
        .delete(`http://localhost:7777/roomManage/${bookNo}`)
        .then(() => {
          alert("예약을 취소했습니다.");
          this.$router.push({ name: "BookingListPage" });
        })
        .catch((res) => {
          alert(res.response.data.message);
        });
    },
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