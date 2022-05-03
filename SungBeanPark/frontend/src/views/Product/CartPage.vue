<template>
  <body>
    <header-layout></header-layout>
    <product-cart :cartList="cartList"></product-cart>
    <footer-layout></footer-layout>
  </body>
</template>
<script>
import HeaderLayout from "@/components/Header/HeaderLayout.vue"
import FooterLayout from "@/components/Footer/FooterLayout.vue"
import ProductCart from "@/components/Product/ProductCart.vue"
import { mapActions, mapState } from "vuex"
import axios from "axios"
export default {
  name: "CartPage",
  components: { HeaderLayout, FooterLayout, ProductCart },

  data() {
    return {
      memberNo: "",
    }
  },
  mounted() {
    this.fetchCartList(this.memberNo)
  },
  computed: {
    ...mapState(["cartList"]),
  },

  methods: {
    ...mapActions(["fetchCartList"]),
  },
  created() {
    if (this.$store.state.userInfo != null) {
      this.memberNo = this.$store.state.userInfo.memberNo
      axios
        .get(`http://localhost:8888/cart/cartList/${this.memberNo}`)
        .then((res) => {
          this.cartList = res.data
        })
        .catch((err) => {
          console.log(err)
        })
    }
  },
}
</script>
<style scoped></style>
