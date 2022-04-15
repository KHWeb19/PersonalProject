<template>
    <div>
       <h1> Register Page </h1>
       <br>
       <store-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import StoreRegisterForm from '@/components/findStore/StoreRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'TipRegisterPage',
    components: {
        StoreRegisterForm
    },
    methods: {
      onSubmit (payload) {
        const { city, gu, dong, adress, storeName } = payload
        
        let formData = new FormData()
        formData.append('storeName', storeName)

        axios.post('http://localhost:7777/storeboard/register', { city, gu, dong, adress, storeName })
                .then(() => {
                    alert('게시물 등록 성공!')
                    this.$router.push({
                        name: 'storeBoardListPage'
                    })
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        }
    }
}
</script>

<style scoped>

</style>