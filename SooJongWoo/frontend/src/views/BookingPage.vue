<template>
  <div>
    <div class="intro-top">
      <div class="container">
        <div>
          <div class="intro-top">
            <div class="container">
              <v-container class="calendar">
                <v-row>
                  <v-col md="6" class="book-calendar">
                    <div style="margin-top: 40%">
                      <v-btn text @click="prev">
                        <v-icon>mdi-chevron-left </v-icon>
                      </v-btn>
                      <v-btn text @click="next">
                        <v-icon>mdi-chevron-right</v-icon>
                      </v-btn>

                      <v-sheet height="400" width="600">
                        <v-calendar
                          ref="calendar"
                          v-model="reservedDate"
                          :type="type"
                          @click:date="view"
                        ></v-calendar>
                      </v-sheet>
                    </div>
                  </v-col>

                  <v-col md="6">
                    <div class="overlay1">
                      <v-simple-table style="border: 2px solid #edeeee">
                        <h2>선택일</h2>
                        <h3>
                          <strong>{{ reservedDate }}</strong>
                        </h3>
                        <v-divider></v-divider>
                        <div class="text-box">
                          <h5><b>전화번호 : </b> 010-6600-2887</h5>
                          <h5><b>결제방법 : </b> 무통장</h5>
                          <h5><b>이용안내 : </b></h5>
                          <h5>
                            - 달력에서 원하시는 날짜를 선택 하시면 예약 가능한
                            객실정보가 보여집니다.
                          </h5>
                          <h5>
                            - 예약 전 예약규정을 반드시 숙지하시고 예약을 하시기
                            바랍니다.
                          </h5>
                          <h5>
                            - 선택란의 체크박스를 체크 후 예약하기 버튼을
                            누르시면 예약이 진행 됩니다.
                          </h5>
                          <h5>- 2박 이상의 경우 1박씩 예약하셔야 합니다.</h5>
                        </div>
                      </v-simple-table>
                    </div>
                  </v-col>
                </v-row>
              </v-container>
            </div>
            <div>
              <p>객실선택</p>
              <v-divider></v-divider>
              <div>
                <div>
                  <v-col cols="12" sm="12">
                    <table>
                      <tr>
                        <td>
                          <v-checkbox
                            v-model="roomId"
                            id="Rose Room"
                            value="Rose Room"
                            :disabled="this.roomNum.indexOf('Roes Room') != -1"
                          ></v-checkbox>
                        </td>
                        <td>
                          <v-img
                            width="200"
                            src="https://images.pexels.com/photos/6580228/pexels-photo-6580228.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                          >
                          </v-img>
                        </td>
                        <td width="40%">
                          <strong># Rose Room</strong><br />
                          기준 2명/ 최대 2명<br />150,000원
                        </td>
                        <td width="15%">
                          기간<v-select
                            :items="['1일']"
                            v-model="period"
                            label="1일"
                            dense
                            disabled
                            flat
                            solo
                            outlined
                          ></v-select>
                        </td>
                        <td width="15%">
                          인원<v-select
                            label="2인"
                            dense
                            disabled
                            flat
                            solo
                            outlined
                            :items="['2인']"
                            v-model="personNum"
                          ></v-select>
                        </td>
                        <td width="40%">
                          <h6>즉시결제</h6>
                          <h1 style="color: black">150,000원</h1>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <v-checkbox
                            value="Sunflower Room"
                            v-model="roomId"
                            :disabled="this.roomNum.indexOf('Sunflower') != -1"
                            required
                            id="Sunflower Room"
                          ></v-checkbox>
                        </td>
                        <td>
                          <v-img
                            width="200"
                            src="https://images.pexels.com/photos/6394651/pexels-photo-6394651.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                          >
                          </v-img>
                        </td>
                        <td width="40%">
                          <strong># Sunflower Room</strong><br />
                          기준 4명/ 최대 4명<br />250,000원
                        </td>
                        <td width="15%">
                          기간<v-select
                            :items="['1일']"
                            v-model="period"
                            label="1일"
                            dense
                            disabled
                            flat
                            solo
                            outlined
                          ></v-select>
                        </td>
                        <td width="15%">
                          인원<v-select
                            label="4인"
                            dense
                            disabled
                            flat
                            solo
                            outlined
                            :items="['4인']"
                            v-model="personNum"
                          ></v-select>
                        </td>
                        <td width="40%">
                          <h6>즉시결제</h6>
                          <h1 style="color: black">250,000원</h1>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <v-checkbox
                            v-model="roomId"
                            :disabled="this.roomNum.indexOf('Violet') != -1"
                            id="Violet Room"
                            value="Violet Room"
                            required
                          ></v-checkbox>
                        </td>
                        <td>
                          <v-img
                            width="200"
                            src="https://images.pexels.com/photos/6585612/pexels-photo-6585612.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                          >
                          </v-img>
                        </td>
                        <td width="40%">
                          <strong># Violet Room</strong><br />
                          기준 2명/ 최대 2명<br />150,000원
                        </td>
                        <td width="15%">
                          기간<v-select
                            :items="['1일']"
                            v-model="period"
                            label="1일"
                            dense
                            disabled
                            flat
                            solo
                            outlined
                          ></v-select>
                        </td>
                        <td width="15%">
                          인원<v-select
                            label="2인"
                            dense
                            disabled
                            flat
                            solo
                            outlined
                            :items="['2인']"
                            v-model="personNum"
                          ></v-select>
                        </td>
                        <td width="40%">
                          <h6>즉시결제</h6>
                          <h1 style="color: black">150,000원</h1>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <v-checkbox
                            v-model="roomId"
                            :disabled="this.roomNum.indexOf('Lily') != -1"
                            id="Lily Room"
                            value="Lily Room"
                            required
                          ></v-checkbox>
                        </td>
                        <td>
                          <v-img
                            width="200"
                            src="https://images.pexels.com/photos/6238614/pexels-photo-6238614.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                          >
                          </v-img>
                        </td>
                        <td width="40%">
                          <strong># Lily Room</strong><br />
                          기준 2명/ 최대 2명<br />200,000원
                        </td>
                        <td width="15%">
                          기간<v-select
                            :items="['1일']"
                            v-model="period"
                            label="1일"
                            dense
                            disabled
                            flat
                            solo
                            outlined
                          ></v-select>
                        </td>
                        <td width="15%">
                          인원<v-select
                            label="2인"
                            dense
                            disabled
                            flat
                            solo
                            outlined
                            :items="['2인']"
                            v-model="personNum"
                          ></v-select>
                        </td>
                        <td width="40%">
                          <h6>즉시결제</h6>
                          <h1 style="color: black">200,000원</h1>
                        </td>
                      </tr>
                    </table>
                  </v-col>
                </div>
              </div>
              <div class="justify-center">
                <v-layout justify-center>
                  <v-dialog v-model="dialog" persistent max-width="1000px">
                    <template v-slot:activator="{ on }">
                      <v-btn
                        color="blue"
                        width="150px"
                        height="50px"
                        style="margin: 100px 0px 150px 0px"
                        v-on="on"
                        >예약하기</v-btn
                      >
                      <v-btn
                        color="blue lighten-3"
                        width="150px"
                        style="margin: 100px 0px 150px 30px"
                        height="50px"
                        router
                        :to="{ name: 'ReservationPage' }"
                        >취소</v-btn
                      >
                    </template>
                    <v-card>
                      <v-toolbar color="blue darken-3">
                        <v-toolbar-title
                          ><h2 style="color: white">
                            객실예약
                          </h2></v-toolbar-title
                        >
                        <v-btn
                          text
                          x-large
                          color="white"
                          class="exit"
                          @click="onClick()"
                        >
                          <v-icon>mdi-close-circle</v-icon>
                        </v-btn>
                      </v-toolbar>
                      <v-card-text>
                        <v-container grid-list-md>
                          <v-layout wrap>
                            <v-flex>
                              <v-container>
                                <table class="info-table">
                                  <tr>
                                    <td width="10%" style="text-align: center">
                                      <b>객실명</b>
                                    </td>
                                    <td width="50%" style="text-align: center">
                                      <b>이용일</b>
                                    </td>
                                    <td width="40%" style="text-align: center">
                                      <b>요금</b>
                                    </td>
                                  </tr>
                                  <tr>
                                    <td style="text-align: center">
                                      <h5>{{ roomId }}</h5>
                                    </td>
                                    <td style="text-align: center">
                                      <h5>{{ reservedDate }}</h5>
                                    </td>
                                    <td style="text-align: center">
                                      <h5 v-if="this.roomId == 'Rose Room'">
                                        150,000
                                      </h5>
                                      <h5
                                        v-if="this.roomId == 'Sunflower Room'"
                                      >
                                        250,000
                                      </h5>
                                      <h5 v-if="this.roomId == 'Violet Room'">
                                        150,000
                                      </h5>
                                      <h5 v-if="this.roomId == 'Lily Room'">
                                        200,000
                                      </h5>
                                    </td>
                                  </tr>
                                </table>
                              </v-container>
                              <v-container>
                                <v-radio-group>
                                  <v-radio
                                    color="indigo"
                                    label="무통장입금"
                                    :rules="[(v) => !!v || '필수']"
                                    required
                                  ></v-radio>
                                </v-radio-group>
                                <h5>
                                  예약계좌 :
                                  <b>우리 1002-256-722604 (예금주: 호텔)</b>
                                </h5>
                                <v-text-field
                                  label="입금자명"
                                  :rules="[(v) => !!v || '필수정보입니다.']"
                                  type="bankName"
                                  v-model="bankName"
                                  required
                                  flat
                                  outlined
                                >
                                </v-text-field>
                              </v-container>

                              <v-container>
                                <v-checkbox
                                  :rules="[(v) => !!v || '필수']"
                                  label="이용약관 및 취소/환불규정 동의"
                                  required
                                ></v-checkbox>
                                <h5>
                                  예약금 입금 시 <b>12시간</b> 안에 입금완료
                                  하셔야 합니다.<br />
                                  <b>미입금 시 자동 예약취소됩니다.</b>
                                </h5>
                              </v-container>
                            </v-flex>
                          </v-layout>
                        </v-container>
                      </v-card-text>

                      <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn
                          text
                          color="blue darken-1"
                          @click="onSubmit()"
                          outlined
                        >
                          예약하기
                        </v-btn>
                      </v-card-actions>
                    </v-card>
                  </v-dialog>
                </v-layout>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import { ALREADYS } from "@/store/mutation-types";
import axios from "axios";
export default {
  name: "BookingPage",
  data() {
    return {
      reservedDate: new Date(
        Date.now() - new Date().getTimezoneOffset() * 60000
      )
        .toISOString()
        .substr(0, 10),
      dialog: false,
      type: "month",
      room: false,
      roomId: "",
      personNum: "",
      bankName: "",
      roomCnt: 1,
      period: 1,
      price: "",
      userId: "",
      roomNum: [],
    };
  },
  methods: {
    prev() {
      this.$refs.calendar.prev();
    },
    next() {
      this.$refs.calendar.next();
    },
    onClick() {
      this.dialog = false;
    },
    view() {
      axios
        .get("http://localhost:7777/room/already", {
          params: { reservedDate: this.reservedDate },
        })
        .then((res) => {
          if (res.data != "") {
            this.$store.commit(ALREADYS, res.data);
            this.roomNum = [];
            for (var i = 0; i <= res.data.length - 1; i++) {
              this.roomNum.push(res.data[i].roomId);
            }
            console.log(this.roomNum);
            console.log(this.roomNum.indexOf(res.data[0].roomId));
          } else {
            this.roomNum = [];
          }
        })
        .catch((res) => {
          alert(res.response.data.message);
        });
    },
    onSubmit() {
      if (this.roomId == "Rose Room" || this.roomId == "Violet Room") {
        this.personNum = "2";
        this.price = "150000";
      } else if (this.roomId == "Sunflower Room") {
        this.personNum = "4";
        this.price = "250000";
      } else {
        this.personNum = "2";
        this.price = "200000";
      }
      this.userId = this.$cookies.get("user");
      const {
        roomId,
        personNum,
        period,
        price,
        roomCnt,
        bankName,
        reservedDate,
        userId,
      } = this;
      axios
        .post("http://localhost:7777/room/book", {
          roomId,
          personNum,
          period,
          price,
          roomCnt,
          bankName,
          reservedDate,
          userId,
        })
        .then((res) => {
          if (res.data != "") {
            alert("예약이 완료되었습니다.");
            this.dialog = false;
            this.$router.push({ name: "MyReservation" });
          } else {
            alert("이미 예약된 방입니다.");
          }
        })
        .catch((res) => {
          alert(res.response.data.message);
        });
    },
  },
};
</script>

<style scoped>
.month {
  visibility: visible;
  width: 150px;
}
.exit {
  position: relative;
  left: 82%;
}
.info-table {
  border: 2px solid #dfdfdf;
}
.calendar {
  position: relative;
  right: 5%;
  bottom: 10%;
  z-index: 9;
}
.intro-top {
  background: #f6f7f7;
}
.container {
  position: relative;
}
.overlay1 {
  position: relative;
  z-index: 9;
  left: 20%;
  width: 600px;
  margin: 60% 0% 60% 0%;
  height: 200px;
}
.pay-message {
  position: relative;
  left: 20%;
  margin: 3% 0% 5% 0%;
}
.pay-btn {
  position: relative;
  left: 10%;
}
.back-box {
  background: #f6f7f7;
  height: 200vh;
}
.text-box {
  margin: 4% 0% 5% 0%;
}
.book-calendar {
  position: relative;
  padding: 5% 0% 0% 0%;
  size: 100%;
}
.info-text {
  margin: 5% 0% 5% 0%;
}
.pay-box {
  margin: 5% 0% 5% 0%;
  position: relative;
}
.top-tr {
  background-color: #bbdefb;
}
.btn-box {
  padding: 18px 10px 18px 10px;
  text-align: center;
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
  padding: 5px 0px 18px 0px;
}
.about-top {
  padding-top: 10vh;
}
h1 {
  font-family: "Cinzel";
  font-size: 30px;
  text-align: center;
  margin-top: 10px;
}
h2 {
  font-family: "Nanum Myeongjo";
  font-size: 25px;
  text-align: center;
  overflow: visible;
  margin-top: 15px;
}
h3 {
  font-family: "Cinzel";
  font-size: 50px;
  color: coral;
  text-align: center;
}
h4 {
  margin-top: 10%;
  font-family: "Nanum Myeongjo";
  font-size: 35px;
}
h5 {
  font-size: 15px;
  padding: 0px 20px 3px 20px;
}
h6 {
  font-size: 20px;
  padding: 0px 20px 0px 20px;
  text-align: center;
}
</style>