<template>
  <div>
    <v-container>
      <p class="display-3 font-weight-light text-center pa-4">MY CART</p>
      
      <v-row>
        <v-col :cols="12" md="9" sm="12">
          <v-simple-table>
            <template v-slot:default>
              <thead>
                <tr>
                  <th class="text-center">ITEM</th>
                  <th class="text-center">PRICE</th>
                  <th class="text-center">QUANTITY</th>
                  <th class="text-center">TOTAL</th>
                  <th class="text-center"></th>
                </tr>
              </thead>
              <tbody align="center">
                <tr v-for="cartItem in cartItems" :key="cartItem.id">
                  <td>
                    <v-list-item>
                      <v-list-item-avatar>
                        <v-img :src="cartItem.product.imageURL" alt="">
                        </v-img>
                      </v-list-item-avatar>

                      <v-list-item-content>
                        <v-list-item-title>
                          <router-link :to="{ name: 'ShowDetails', params: { id: cartItem.product.id } }">
                            {{ cartItem.product.name }}
                          </router-link>
                        </v-list-item-title>
                      </v-list-item-content>
                    </v-list-item>
                  </td>
                  <td>₩ {{ cartItem.product.price }}</td>
                  <td>
                    <p>{{ cartItem.quantity }}</p>
                  </td>
                  <td> ₩ {{ cartItem.product.price * cartItem.quantity }} </td>
                  <td>
                     <v-btn plain @click="deleteItem(cartItem.id)">
                        <v-icon x-small>mdi-close</v-icon>
                      </v-btn>
                  </td>
                </tr>
              </tbody>
            </template>
          </v-simple-table>
        </v-col>
  
      <v-col :cols="12" md="3" sm="12" style="background-color: lightgray">
        <p class="headline">Order Summary</p>
        <v-simple-table>
          <template v-slot:default>
            <tbody>
              <tr>
                <td>주문합계</td>
                <td class="text-right" style="width: 100px;">₩ {{ totalCost }}</td>
              </tr>
              <tr>
                <td>배송비</td>
                <td class="text-right" style="width: 100px;">₩ 3000 </td>
              </tr>
              <tr>
                <td class="font-weight-bold">TOTAL</td>
                <td class="font-weight-bold text-right" style="width: 100px;">₩ {{ totalCost + 3000 }}</td>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
        <div class="text-center">
          <checkout-form/>
        </div>
      </v-col>
    </v-row>
    
    </v-container>
  </div>
</template>

<script>
import axios from 'axios'
import CheckoutForm from '../../components/cart/CheckoutForm.vue';

export default {
  components: { 
    CheckoutForm 
  },
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


</style>