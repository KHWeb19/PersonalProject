<template>
  <div id="book" class="img">
    <menu-bar />
    <v-card class="card-box">
      <v-navigation-drawer permanent style="float: left">
        <v-list>
          <v-list-item link>
            <v-list-item-content>
              <v-list-item-title class="text-h6">
                {{ userId }}
              </v-list-item-title>
              <v-list-item-subtitle>회원님, 환영합니다.</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-divider></v-divider>

        <v-list nav dense>
          <v-list-item route :to="{ name: 'UserList' }">
            <v-list-item-icon>
              <v-icon>mdi-account</v-icon>
            </v-list-item-icon>
            <v-list-item-title>회원정보</v-list-item-title>
          </v-list-item>
          <v-list-item route :to="{ name: 'MyReservation' }">
            <v-list-item-icon>
              <v-icon>mdi-door</v-icon>
            </v-list-item-icon>
            <v-list-item-title>예약내역</v-list-item-title>
          </v-list-item>
          <v-list-item route :to="{ name: 'BookingPage' }">
            <v-list-item-icon>
              <v-icon>mdi-feather</v-icon>
            </v-list-item-icon>
            <v-list-item-title>예약하기</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>

      <div class="user-info">
        <v-row justify="center" style="margin: 3%">
          <h4 style="margin-top: 5%">예약 상세정보</h4>
        </v-row>

        <reservation-read-form
          v-if="book"
          :book="book"
          :bookReadDates="bookReadDates"
        />
        <p v-else>로딩중 ......</p>

        <v-layout justify-center>
          <v-dialog v-model="dialog" persistent max-width="400px">
            <template v-slot:activator="{ on }">
              <v-btn text outlined color="black lighten-1" v-on="on"
                >예약취소</v-btn
              >
              <v-btn
                outlined
                route
                :to="{ name: 'MyReservation' }"
                color="blue lighten-1"
                style="margin-left: 20px"
                >전체예약내역</v-btn
              >
            </template>
            <v-card>
              <v-toolbar color="white darken-3" flat height="50">
                <v-btn text x-large class="exit" plain @click="cancle()">
                  <v-icon>mdi-close-circle</v-icon>
                </v-btn>
              </v-toolbar>
              <v-card-text>
                예약을 취소하시겠습니까?<br />
                취소 시 예약서비스를 통해 다시 예약하셔야 합니다.
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
      </div>
    </v-card>
  </div>
</template>

<script>
import MenuBar from "@/views/MenuBar.vue";
import ReservationReadForm from "@/components/member/ReservationReadForm.vue";
import { mapState, mapActions } from "vuex";
import axios from "axios";

export default {
  name: "ReservationReadPage",
  props: {
    bookNo: {
      type: String,
      required: true,
    },
  },
  components: {
    ReservationReadForm,
    MenuBar,
  },
  data() {
    return {
      userId: this.$cookies.get("user"),
      dialog: false,
    };
  },
  computed: {
    ...mapState(["book", "bookReadDates"]),
  },
  created() {
    this.fetchBook(this.bookNo).catch((err) => {
      alert(err.response.data.message);
      this.$router.push();
    });
  },
  methods: {
    cancle() {
      this.dialog = false;
    },
    ...mapActions(["fetchBook"]),
    onDelete() {
      const { bookNo } = this.book;
      axios
        .delete(`http://localhost:7777/room/${bookNo}`)
        .then(() => {
          alert("예약을 취소했습니다.");
          this.dialog = false;
          this.$router.push({ name: "MyReservation" });
          this.$store.state.books = null;
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
  font-family: "Cinzel";
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
.reserve {
  display: flex !important;
  flex-direction: column;
}
.exit {
  margin-left: 85%;
}
/*  */
.user-info {
  float: left;
  width: 75%;
  margin-top: 5%;
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