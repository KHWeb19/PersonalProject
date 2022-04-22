<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h4 class="pt-3"> Edit Product</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <form v-if="product">
                    <div class="form-group">
                        <label> Category</label>
                        <select class="form-control" v-model="product.categoryId" required>
                            <option v-for="category of categories"
                                    :key="category.id"
                                    :value="category.id"> {{category.categoryName}}
                            </option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" v-model="product.name" required/>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <input type="text" class="form-control" v-model="product.description" required/>
                    </div>
                    <div class="form-group">
                        <label>Image URL</label>
                        <input type="text" class="form-control" v-model="product.imageURL" required/>
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input type="number" class="form-control" v-model="product.price" required/>
                    </div>
                    <button type="button" class="btn btn-primary"
                            @click="editProduct" >Submit</button>
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</template>
<script>
import axios from 'axios'

export default {
    data() {
        return {
            product: '',
            id: ''
        }
    },
    props: {
        categories: {

        },
        products: {

        }
    },
        methods: {
            async editProduct() {
                console.log('product', this.product)

                axios.post(`http://localhost:7777/product/update/${this.id}`, this.product)
                .then(() => {
                        this.$emit("fetchData")
                        alert("상품이 수정되었습니다.")
                        this.$router.push({path: '/product'})
                    })
                .catch((err) => {
                        console.log('상품 수정 에러: ' + err)
                })

                // await axios.post(`${this.baseURL}product/update/${this.id}`,
                //     this.product)
                //     .then(() => {
                //         this.$emit("fetchData");
                //         this.$router.push({name: 'AdminProduct'})
                //         swal({
                //             text: "product has been updated successfully",
                //             icon: "success"
                //         })
                //     }).catch(err => console.log('err', err));
            }
        },
        mounted() {
            this.id = this.$route.params.id;
            this.product = this.products.find(product => product.id == this.id)
            console.log(this.id,this.product)
        }
    }
</script>