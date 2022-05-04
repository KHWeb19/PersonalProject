<template>
  <v-container>
    <v-row>
      <v-col>
        <h4>{{ category.categoryName }}</h4>
      </v-col>
    </v-row>
    <hr>
    <v-row>
      <!-- 상품 이미지 -->
      <v-col>
        <img :src="product.imageURL" class="img-fluid" />
      </v-col>
      <!--상품 상세정보-->
      <v-col>
        <h4 style="text-decoration: underline; text-underline-position:under;">{{ product.description }}</h4>
        <p>{{ product.name }}</p>
        <br>
        <h5 class="font-weight-bold">₩ {{ product.price }}</h5>
          <div class="input-group col-md-3 col-4 p-0 mt-5">
            <div class="input-group-prepend">
              <span class="input-group-text">Quantity</span>
            </div>
            <input type="number" class="form-control" v-model="quantity" />
        </div>
        <hr class="mt-10">
        <div>
          <v-col>
            <v-btn class="grey white--text mt-3 mr-3"  type="button" id="add-to-cart-button" @click="addToCart">
                  SHOPPING BAG
            </v-btn>
        <checkout-form/>
          </v-col>
        </div>
      </v-col>
    </v-row>
    <hr class="mt-10">
    <div>
      <qn-a-register-form @submit="onSubmit"/>
    </div>
  </v-container>
</template>

<script>

import axios from 'axios'
import CheckoutForm from '@/components/cart/CheckoutForm.vue';
import QnARegisterForm from '../../components/qna/QnARegisterForm.vue';

export default {
  components: { 
    CheckoutForm,
    QnARegisterForm 
    },
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
    },
    onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/qna/register', { title, writer, content })
                    .then(() => {
                        alert('게시물 등록 성공!')

                        this.$router.push({
                            name: 'ShowDetails'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
  
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
/* #add-to-cart-button {
  background-color: #febd69;
} */
</style>