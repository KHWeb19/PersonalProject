<template>
  <div align="center" class="member-box">
    <v-container v-if="!books || (Array.isArray(books) && books.length === 0)">
      <div style="margin: 5% 0% 10% 0%; text-align: center">
        예약 내역이 존재하지 않습니다.
      </div>
    </v-container>

    <v-container
      v-else
      v-for="book in books"
      :key="book.bookNo"
      class="reserve"
    >
      <v-card width="700" class="over">
        <v-card-title class="book-title">{{ book.regDate }}</v-card-title>
        <v-card-actions>
          <div style="margin: 3%"><b>예약번호 :</b> {{ book.bookNo }}</div>
          <div style="margin: 3%"><b>객실명 :</b> {{ book.roomId }}</div>
          <div style="margin: 3%"><b>예약일 :</b> {{ book.reservedDate }}</div>
        </v-card-actions>

        <v-flex xs8 sm12 md12>
          <v-card-actions>
            <v-btn
              outlined
              color="blue lighten-1"
              style="margin-left: 83%"
              route
              :to="{
                name: 'ReservationReadPage',
                params: { bookNo: book.bookNo.toString() },
              }"
              >상세보기</v-btn
            >
          </v-card-actions>
        </v-flex>
      </v-card>
    </v-container>
    <br />
  </div>
</template>

<script>
export default {
  name: "MyReservationForm",
  props: {
    books: {
      type: Array,
    },
  },
};
</script>

<style scoped>
table {
  width: 55%;
  border: 1px solid #ebecec;
}
.top-tr {
  background-color: #f6f7f7;
}
.member-box {
  margin-top: 2%;
}
.book-title {
  background: linear-gradient(
    45deg,
    rgba(0, 68, 255, 0.61),
    rgba(143, 206, 243, 0.425)
  );
  color: white;
}
.exit {
  position: relative;
  left: 85%;
}
.reserve {
  margin: 5% 0% 5% 0%;
}
</style>