<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-4">
        <form enctype="multipart/form-data" @submit.prevent="onSubmit">
          <div>
            <input
              type="file"
              id="files"
              ref="files"
              multiple
              v-on:change="handlerFileUpload()"
            />
          </div>
          <div>
            <img class="preview" :src="image" alt="" />
          </div>
          <div v-if="image == ''">이미지 미리보기</div>
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
            <button type="submit">등록하기</button>
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
      files: "",
      image: "",
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
      const file = this.$refs.files.files[0]
      if (file == null) {
        alert("대표 이미지를 등록해주세요.")
        return
      }
      this.$emit("submit", {
        productName,
        productPrice,
        gender,
        productDiscountPrice,
        discount,
        rating,
        file,
      })
    },
    handlerFileUpload() {
      var image = this.$refs["files"].files[0]
      const url = URL.createObjectURL(image)
      this.image = url
      this.files = this.$refs.files.files[0]
    },
  },
}
</script>
<style></style>
