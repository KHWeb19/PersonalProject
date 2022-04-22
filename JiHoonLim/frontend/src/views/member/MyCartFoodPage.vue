<template>
  <div>
    <my-cart-food-list :myCartFoods="myCartFoods" />
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
    };
  },
  computed: {
    ...mapState(["myCartFoods"]),
  },
  mounted() {
    this.fetchMyCartFoodList();
  },
  methods: {
    ...mapActions(["fetchMyCartFoodList"]),
  },

  created() {
    axios
      .get("http://localhost:7777/member/myCart/list")
      .then((res) => {
        this.pageArray = res.data;
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>
