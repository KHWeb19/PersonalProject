<template>
  <form>
    <div class="room-box">
      <v-col cols="12" md="12">
        <v-container>
          <v-text-field
            label="예약번호"
            required
            height="5vh"
            readonly
            disabled
            :value="room.bookNo"
            type="bookNo"
          >
          </v-text-field>

          <v-text-field
            label="방번호"
            required
            height="5vh"
            readonly
            disabled
            :value="room.roomId"
            type="roomId"
          >
          </v-text-field>

          <v-text-field
            label="가격"
            required
            height="5vh"
            readonly
            disabled
            :value="room.price"
            type="price"
          >
          </v-text-field>

          <v-text-field
            label="입금자명"
            required
            height="5vh"
            readonly
            disabled
            :value="room.bankName"
            type="bankName"
          >
          </v-text-field>

          <v-text-field
            label="아이디"
            required
            height="5vh"
            readonly
            disabled
            :value="room.userId"
            type="userId"
          >
          </v-text-field>
        </v-container>
      </v-col>
    </div>
  </form>
</template>

<script>
export default {
  name: "RoomRead",
  props: {
    room: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>
.room-box {
  text-align: center;
  width: 80%;
  margin: 0 auto;
}
.register-box {
  border: 1px solid #cccccc;
  background-color: white;
  float: left;
  width: 500px;
  height: 500px;
}
.btn-size {
  margin: 0 auto;
  text-align: center;
  width: 50%;
  padding: 3% 0% 5% 0%;
}
h1 {
  font-family: "Gowun Dodum";
  font-size: 30px;
  margin-top: 5%;
  text-align: center;
}
</style>