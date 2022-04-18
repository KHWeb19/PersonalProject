<template>
  <div>
    <v-row>
      <v-col justify="center">
        <form @submit.prevent="onSubmit">
          <div>
            <v-text-field
              style="width: 500px"
              v-model="comment"
              label="댓글창"
              clearable
              outlined
              color="orange"
            />
          </div>
          <div>
            <v-btn type="submit">등록</v-btn>
          </div>
        </form>
        <table>
          <tr v-for="commentList in foodBoardComments" :key="commentList.id">
            <td>{{ commentList.comment }}</td>
            <td>{{ commentList.regDate }}</td>
            <td>{{ commentList.commentWriter }}</td>
            <v-btn @click="onDelete(commentList.commentNo)">삭제</v-btn>
          </tr>
        </table>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "FoodBoardComment",
  props: {
    foodBoardComments: {
      type: Array,
    },
  },
  data() {
    return {
      comment: "",
      commentWriter: "",
    };
  },
  created() {
    this.commentWriter = this.$store.state.userInfo.nickName;
  },
  methods: {
    onSubmit() {
      const { comment, commentWriter } = this;
      this.$emit("submit", { comment, commentWriter });
    },
    onDelete(commentNo) {
      axios
        .delete(
          `http://localhost:7777/foodBoard/comment/${commentNo}`,
          commentNo
        )
        .then(() => {
          alert("삭제 성공!");
          history.go(0);
        })
        .catch(() => {
          alert("삭제 실패");
        });
    },
  },
};
</script>
