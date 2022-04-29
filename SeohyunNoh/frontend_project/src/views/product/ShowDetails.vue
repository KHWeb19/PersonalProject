<template>
  <div class="container">
    <div class="row pt-5">
      <div class="col-md-1"></div>
      <!-- 상품 이미지 -->
      <div class="col-md-4 col-12">
        <img :src="product.imageURL" class="img-fluid" />
      </div>
      <!--상품 상세정보-->
      <div class="col-md-6 col-12 pt-3 pt-md-0">
        <h4>{{ product.name }}</h4>
        <h6 class="catgory font-italic">{{ category.categoryName }}</h6>
        <h6 class="font-weight-bold">₩ {{ product.price }}</h6>
        <p>
          {{ product.description }}
        </p>
        <div class="d-flex flex-row justify-content-between">
            <!-- 수량 입력 -->
          <div class="input-group col-md-3 col-4 p-0">
            <div class="input-group-prepend">
              <span class="input-group-text">Quantity</span>
            </div>
            <input type="number" class="form-control" v-model="quantity" />
          </div>

            <!-- 장바구니 담기 --> 
          <div class="input-group col-md-3 col-4 p-0">
            <button class="btn" type="button" id="add-to-cart-button" @click="addToCart">
              Add to Cart
            </button>
          </div>
        </div>
        <!-- <div class="features pt-3">
          <h5><strong>Features</strong></h5>
          <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
          </ul>
        </div> -->
      </div>
    </div>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  data() {
    return {
      product: {},
      category: {},
      quantity: 1,
    };
  },
  props: {
      products: {

      },
      categories: {

      }
  },
  methods: {
    addToCart() {

      const Cart = {
        memberId: this.$store.state.userInfo.id,
        productId: this.id,
        quantity: this.quantity
      }
        axios.post('http://localhost:7777/cart/add', Cart)
        .then((res) =>{
          if(res.status == 201) {
            alert("장바구니에 담았습니다.")
            console.log(res)
            this.$emit("fetchData")
          }
        }) 
        .catch((err) => {
          console.log(err)
        })
    //   axios
    //     .post(`${this.baseURL}/cart/add?token=${this.token}`, {
    //       productId: this.id,
    //       quantity: this.quantity,
    //     })
    //     .then((res) => {
    //       if (res.status == 201) {
    //         swal({
    //           text: "Product added in cart",
    //           icon: "success",
    //         });
    //         this.$emit("fetchData");
    //       }
    //     })
    //     .catch((err) => console.log("err", err));
    },
  },
  mounted() {
    this.id = this.$route.params.id;
    this.product = this.products.find((product) => product.id == this.id);
    this.category = this.categories.find((category) => category.id == this.product.categoryId)
  }
}
</script>

<style>
.category {
  font-weight: 400;
}
#add-to-cart-button {
  background-color: #febd69;
}
</style>