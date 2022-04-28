<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h3 class="pt-3">
          Shopping cart
        </h3>
      </div>
    </div>

    <!-- 받아온 cartItems를 루프돌며 분배 --> 
    <div v-for="cartItem in cartItems" :key="cartItem.id" class="row mt-2 pt-3 justify-content-around">
      <div class="col-2"></div>
      <div class="col-md-3 embed-responsive embed-responsive-16by9">
        <img :src="cartItem.product.imageURL" alt=""
          class="w-100 card-image-top embed-responsive-item"
          style="object-fit: cover"/>
      </div>

      <!-- 상품명, 상품가격, 상품수량 -->
      <div class="col-md-5 px-3">
        <div class="card-block px-3">
          <h6 class="card-title">
            <router-link :to="{ name: 'ShowDetails', params: { id: cartItem.product.id } }">
              {{ cartItem.product.name }}
            </router-link>
          </h6>

          <p class="mb-0 font-weight-bold" id="item-price">
            ₩ {{ cartItem.product.price }}
          </p>

          <p class="mb-0" style="float:left">
            Quantity:{{ cartItem.quantity }}
          </p>
        </div>

        <p class="mb-0" style="float:right">
          Total:
          <span class="font-weight-bold">
            ₩ {{ cartItem.product.price * cartItem.quantity }}
          </span>
        </p>
        <br />
        <v-btn plain @click="deleteItem(cartItem.id)">
            <v-icon x-small>mdi-close</v-icon>
        </v-btn>
      </div>
      <div class="col-2"></div>
      <div class="col-12"><hr /></div>
    </div>

    <!-- 총합계 , 결제버튼 -->
    <div class="total-cost pt-2 text-right">
      <h5>Total : ₩ {{ totalCost }}</h5>
      <button type="button" class="btn btn-primary confirm" @click="checkout">
        Order
      </button>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      cartItems: [],
      id: '',
      totalCost: 0,
    }
  },
  methods: {
    listCartItems() {
        axios.get(`http://localhost:7777/cart/list/${this.id}`)
        .then((res) =>{
            console.log('list()')
            const result = res.data
            this.cartItems = result.cartItems
            this.totalCost = result.totalCost
        })
        .catch((err) => {
            console.log('err' + err);
        })
    },
    deleteItem(itemId) {
      axios.delete(`http://localhost:7777/cart/delete/${itemId}`)
        .then((res) => {
          if (res.status == 200) {
            this.$router.go(0);
          }
        })
        .catch((err) => console.log('err', err));
    },
    checkout() {
      this.$router.push({ name: 'Checkout' });
    },
  },
  mounted() {
    this.id = this.$store.state.userInfo.id
    this.listCartItems()
  },
};
</script>
<style scoped>
h4,
h5 {
  color: #484848;
  font-size: 700;
}
</style>