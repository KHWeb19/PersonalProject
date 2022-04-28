<template>
  <div>
    <my-cart-food-list :myCartFoods="myCartFoods" :list-array="pageArray" />
  </div>
</template>

<script>
import MyCartFoodList from "@/components/member/MyCartFoodList.vue";
import { mapActions, mapState } from "vuex";
import axios from "axios";

export default {
  name: "MyCartFoodPage",
  components: {
    MyCartFoodList,
  },

  data() {
    return {
      pageArray: [],
      memberNo: "",
    };
  },
  computed: {
    ...mapState(["myCartFoods"]),
  },
  mounted() {
    this.fetchMyCartFoodList(this.memberNo);
  },
  methods: {
    ...mapActions(["fetchMyCartFoodList"]),
  },

  created() {
    if (this.$store.state.userInfo != null) {
      this.memberNo = this.$store.state.userInfo.memberNo;

      axios
        .get(`http://localhost:7777/myCart/list/${this.memberNo}`)
        .then((res) => {
          this.pageArray = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    }
  },
};
</script>
