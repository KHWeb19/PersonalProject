<template>
  <div>
    <Header-Layout></Header-Layout>
    <product-detail v-if="product" :product="product"></product-detail>
    <product-comment
      @submit="onSubmit"
      :productComments="productComments"
    ></product-comment>
    <Footer-layout></Footer-layout>
  </div>
</template>
<script>
import HeaderLayout from "@/components/Header/HeaderLayout.vue"
import ProductDetail from "@/components/Product/ProductDetail.vue"
import ProductComment from "@/components/Product/ProductComment.vue"
import FooterLayout from "@/components/Footer/FooterLayout.vue"
import { mapState, mapActions } from "vuex"
import axios from "axios"

export default {
  name: "ProductDetailPage",
  components: { HeaderLayout, FooterLayout, ProductDetail, ProductComment },
  props: {
    productId: {
      type: String,
    },
  },
  computed: {
    ...mapState(["product", "productComments"]),
  },
  created() {
    this.fetchProduct(this.productId).catch(() => {
      alert("게시물 요청 실패")
    })
    this.fetchProductCommentList(this.productId).catch(() => {
      alert("리뷰 요청 실패")
    })
  },
  methods: {
    ...mapActions(["fetchProduct", "fetchProductCommentList"]),
    onSubmit(payload) {
      const { comment, writer, file } = payload
      let formData = new FormData()
      formData.append("comment", comment)
      formData.append("writer", writer)
      formData.append("file", file)
      console.log(formData)
      axios
        .post(
          `http://localhost:8888/product/comment/register/${this.productId}`,
          formData,
          {
            headers: {
              "Content-Type": "multipart/form-data",
            },
          }
        )
        .then(() => {
          alert("리뷰 등록 성공!")
          this.$router.push({
            name: "ProductDetailPage",
          })
        })
        .catch(() => {
          alert("리뷰 등록 실패!")
        })
    },
  },
}
</script>
<style scoped></style>
