<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-4">
        <form>
          <table>
            <tr>
              <td>상품명</td>
              <input v-model="productName" type="text" />

              <td>상품가</td>
              <input v-model="productPrice" type="number" />

              <td>남여전용</td>
              <input v-model="gender" type="text" />

              <td>할인된 가격</td>
              <input v-model="productDiscountPrice" type="number" />

              <td>할인율</td>
              <input v-model="discount" type="number" />

              <td>별점수</td>
              <input v-model="rating" type="number" />
            </tr>
            <button @click="onSubmit()" type="submit">등록하기</button>
          </table>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "ProductRegister",
  data() {
    return {
      productName: "",
      productPrice: 0,
      gender: "",
      productDiscountPrice: 0,
      discount: 0,
      rating: 0,
    }
  },
  methods: {
    onSubmit() {
      const {
        productName,
        productPrice,
        gender,
        productDiscountPrice,
        discount,
        rating,
      } = this
      this.$emit("submit", {
        productName,
        productPrice,
        gender,
        productDiscountPrice,
        discount,
        rating,
      })
    },
  },
}
</script>
<style></style>
