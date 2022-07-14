<template>
  <div>
    <v-container class="about-top">
      <h1>HAWUL RESERVATION</h1>
      <p>| 예약안내 |</p>
    </v-container>

    <v-divider></v-divider>

    <div class="back-box">
      <div class="container">
        <v-container class="container2">
          <h4>[ 요금안내 ]</h4>
          <v-divider></v-divider>

          <v-container class="info-text">
            예약전화 : 010-6600-2887 / 예약계좌 : 우리 1002-256-722604 (예금주:
            호텔)<br />
            입금대기시간<br />
            1. 예약신청 후 12시간 내로 전액을 입금하셔야 예약이 완료됩니다.<br />
            2. 당일예약/하루 전 예약 시 1시간 내로 결제를 완료해
            주셔야됩니다.<br />
            * 입금 대기 시간이 경과되면 예약 신청이 자동 취소됩니다.<br />
          </v-container>

          <v-simple-table>
            <template v-slot:default>
              <thead class="pay-box">
                <tr>
                  <th class="text-left">객실명</th>
                  <th class="text-left">형태</th>
                  <th class="text-left">기준/최대</th>
                  <th class="text-left">가격</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="item in pays" :key="item.name">
                  <td>{{ item.name }}</td>
                  <td>{{ item.form }}</td>
                  <td>{{ item.num }}</td>
                  <td>{{ item.price }}</td>
                </tr>
              </tbody>
            </template>
          </v-simple-table>

          <h4>[ 이용안내 & 유의사항 ]</h4>
          <v-divider></v-divider>
          <v-container class="info-text">
            - 입실시간:오후 3시 /퇴실시간:오전 11시<br />
            - 전 객실 및 호텔내부는 금연구역입니다. (절대금연)<br />
            - 애완동물은 타 객실 손님을 위해 입실을 금하오니 이점 양해바랍니다.
            <br />
            - 보호자를 동반하지 않은 미성년자는 어떠한 경우라도 입실 하실 수
            없습니다.<br />
            - 화재의 위험이 있는 촛불 및 폭죽사용, 부탄가스 사용을 금지합니다.
            <br />
            - 퇴실 전 객실정리 후 퇴실점검 부탁드립니다.<br />
          </v-container>

          <h4>[ 환불규정 ]</h4>
          <v-divider></v-divider>
          <v-container class="info-text">
            - 예약을 하실 경우에는 신중히 결정하여 주시길 부탁 드립니다.<br />
            - 환불은 입금자 확인후 지정하신 계좌로 보내드립니다.
            (송금수수료제외)<br />
            - 단, 예약 이용일 변경은 예약취소에 해당됩니다. 예약취소 후 다시
            예약을 해 주십시오.<br />
          </v-container>

          <v-simple-table>
            <template v-slot:default>
              <thead class="pay-box">
                <tr>
                  <th class="text-left">취소일기준</th>
                  <th class="text-left">취소수수료</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="items in refunds" :key="items.day">
                  <td>{{ items.day }}</td>
                  <td>{{ items.percent }}</td>
                </tr>
              </tbody>
            </template>
          </v-simple-table>
        </v-container>
      </div>
    </div>
    <v-divider></v-divider>

    <v-container>
      <v-container class="btn-box">
        <v-btn
          color="text-white blue lighten-2"
          @click="reservation()"
          width="200px"
          height="50px"
          ><v-icon>mdi-feather</v-icon>
          실시간 예약
        </v-btn>
      </v-container>
    </v-container>
  </div>
</template>


<script>
import cookies from "vue-cookies";
export default {
  data() {
    return {
      cookie: cookies.get("user"),
      pays: [
        { name: "Rose", form: "커플형", num: "2명/2명", price: "150,000원" },
        {
          name: "Sunflower",
          form: "패밀리형",
          num: "4명/4명",
          price: "250,000원",
        },
        { name: "Violet", form: "커플형", num: "2명/2명", price: "150,000원" },
        { name: "Lily", form: "커플형", num: "2명/2명", price: "200,000원" },
      ],
      refunds: [
        { day: "기본 취소 수수료", percent: "0%" },
        { day: "이용 9일 전", percent: "0%" },
        { day: "이용 8일 전", percent: "10%" },
        { day: "이용 7일 전", percent: "20%" },
        { day: "이용 6일 전", percent: "20%" },
        { day: "이용 5일 전", percent: "20%" },
        { day: "이용 4일 전", percent: "30%" },
        { day: "이용 3일 전", percent: "50%" },
        { day: "이용 2일 전", percent: "70%" },
        { day: "이용 1일 전", percent: "100%(환불불가)" },
        { day: "이용 당일", percent: "100%(환불불가)" },
      ],
    };
  },
  methods: {
    reservation() {
      if (!this.cookie) {
        alert("로그인이 필요한 서비스입니다.");
        this.$router.push({
          name: "MemberLogin",
        });
      } else {
        this.$router.push({
          name: "BookingPage",
        });
      }
    },
  },
};
</script>

<style scoped>
.container {
  position: relative;
}
.container2 {
  width: 900px;
  margin-top: -2%;
  margin-bottom: 3%;
}
.back-box {
  background: #f6f7f7;
}
.info-text {
  margin: 5% 10% 5% 0%;
}
.pay-box {
  margin: 5% 0% 5% 0%;
  position: relative;
  background-color: #ececec;
}
.top-tr {
  background-color: #bbdefb;
}
.btn-box {
  padding: 18px 10px 18px 10px;
  text-align: center;
}
.intro-top {
  text-align: left;
}
.about-img-top {
  max-height: 70vh;
}
.section {
  background: #dcdfdc;
  height: 10vh;
}
p {
  font-family: "Nanum Myeongjo";
  font-size: 18px;
  text-align: center;
  padding: 18px 0px 18px 0px;
}
.about-top {
  padding-top: 3vh;
}

h1 {
  font-size: 40px;
  text-align: center;
  margin-top: 10px;
}
h2 {
  font-family: "MonteCarlo";
  font-size: 150px;
  color: darkgrey;
}
h3 {
  font-size: 80px;
  margin-top: 10px;
  color: darkgrey;
}
h4 {
  margin-top: 10%;
  font-family: "Nanum Myeongjo";
  font-size: 35px;
}
</style>