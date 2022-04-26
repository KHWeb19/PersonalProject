<template>
  <div>
    <Header-Layout></Header-Layout>
    <product-detail v-if="product" :product="product"></product-detail>
    <p v-else>로딩중 ......</p>
    <Footer-layout></Footer-layout>
  </div>
</template>
<script>
import HeaderLayout from "@/components/Header/HeaderLayout.vue"
import ProductDetail from "@/components/Product/ProductDetail.vue"
import FooterLayout from "@/components/Footer/FooterLayout.vue"
import { mapState, mapActions } from "vuex"
import axios from "axios"

export default {
  name: "ProductDetailPage",
  components: { HeaderLayout, FooterLayout, ProductDetail },
  props: {
    productId: {
      type: String,
      required: true,
    },
  },

  computed: {
    ...mapState(["product"]),
  },
  created() {
    this.fetchProduct(this.productId).catch(() => {
      alert("게시물 요청 실패")
    })
  },
  methods: {
    ...mapActions(["fetchProduct"]),
    onDelete() {
      const { productId } = this.product
      axios
        .delete(`http://localhost:8888/product/${productId}`)
        .then(() => {
          alert("삭제 성공!")
          this.$router.push({ name: "ProductPage" })
        })
        .catch(() => {
          alert("삭제 실패! 문제 발생!")
        })
    },
  },
}
</script>
<style></style>
