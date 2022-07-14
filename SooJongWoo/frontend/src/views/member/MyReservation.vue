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
          <h4 style="margin-top: 5%">예약정보</h4>
        </v-row>
        <my-reservation-form :books="books" />
      </div>
    </v-card>
  </div>
</template>

<script>
import MenuBar from "@/views/MenuBar.vue";
import MyReservationForm from "@/components/member/MyReservationForm.vue";
import axios from "axios";
import { mapState } from "vuex";
import { FETCH_BOOK_LIST } from "@/store/mutation-types";
export default {
  name: "MyReservation",
  components: {
    MyReservationForm,
    MenuBar,
  },
  data() {
    return {
      userId: this.$cookies.get("user"),
    };
  },
  computed: {
    ...mapState(["books"]),
  },
  mounted() {
    this.fetchBookList();
  },
  methods: {
    fetchBookList() {
      return axios
        .get("http://localhost:7777/room/lists", {
          params: { userId: this.userId },
        })
        .then((res) => {
          this.$store.commit(FETCH_BOOK_LIST, res.data);
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