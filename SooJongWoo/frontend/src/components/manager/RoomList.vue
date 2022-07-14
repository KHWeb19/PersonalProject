<template>
  <div align="center" class="room-box">
    <v-row align="center" class="table-row">
      <table class="table-a">
        <tr class="top-tr">
          <th width="100">예약번호</th>
          <th width="100">방번호</th>
        </tr>

        <tr v-if="!rooms || (Array.isArray(rooms) && rooms.length === 0)">
          <td colspan="3">등록된 회원이 존재하지 않습니다.</td>
        </tr>
        <tr v-else v-for="room in rooms" :key="room.bookNo">
          <td>
            <router-link
              :to="{
                name: 'BookingReadPage',
                params: { bookNo: room.bookNo.toString() },
              }"
            >
              {{ room.bookNo }}
            </router-link>
          </td>
          <td>{{ room.roomId }}</td>
        </tr>
      </table>

      <table class="table-b">
        <tr class="top-tr">
          <th>예약일</th>
        </tr>

        <tr
          v-if="
            !reserveDate ||
            (Array.isArray(reserveDate) && reserveDate.length === 0)
          "
        >
          <td colspan="1">.</td>
        </tr>
        <tr v-else v-for="dates in reserveDate" :key="dates.reservationNo">
          <td>{{ dates.reservedDate }}</td>
        </tr>
      </table>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "RoomList",
  props: {
    rooms: {
      type: Array,
    },
    reserveDate: {
      type: Array,
    },
  },
  methods: {
    text() {
      console.log(this.$store.state.reserveDate);
    },
  },
};
</script>

<style scoped>
.table-a {
  width: 50%;
  border: 0.5px solid #ebecec;
  float: left;
  margin-bottom: 5%;
}
.table-b {
  width: 30%;
  border: 0.5px solid #ebecec;
  float: left;
  margin-bottom: 5%;
  /* margin-left:50pt; */
}
.table-row {
  margin: 0 auto;
  margin-left: 20%;
  position: relative;
}
.top-tr {
  background-color: #84c0cf33;
}
.member-box {
  margin-top: 2%;
  margin-bottom: 2%;
  width: 83%;
}
th,
td {
  text-align: center;
  height: 80px;
}
.exit {
  position: relative;
  left: 85%;
}
</style>