<template>
    <v-container>
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td>시</td>
                <td>
                    <input type="text" v-model="title" placeholder=" *필수 입력"/>
                </td>
            </tr>
            <tr>
                <td>구</td>
                <td>
                    <input type="text" v-model="writer" placeholder=" *필수 입력"/>
                </td>
            </tr>
            <tr>
                <td>동</td>
                <td>
                    <input type="text" v-model="writer" placeholder=" *필수 입력"/>
                </td>
            </tr>
            <tr>
                <td>주소</td>
                <td>
                    <input type="text" v-model="writer" placeholder=" *필수 입력"/>
                </td>
            </tr>
        </table>

        <div>
            <v-btn type="submit">등록</v-btn>
            <router-link :to="{ name: 'storeBoardList' }">
                <v-btn>
                    취소
                </v-btn>
            </router-link>
        </div>
    </form>
    </v-container>
</template>

<script>
export default {
    name: 'StoreRegisterForm.vue',
    data () {
        return {
            city: '',
            gu: '',
            dong: '',
            address: '',
        }
    },
    methods: {
        created () {
        this.writer = this.$store.state.userInfo.storeName
        },
        onSubmit () {
            const { city, gu, dong, address, storeName } = this
            
            this.$emit('submit', { city, gu, dong, address, storeName })
            console.log(city, gu, dong, address, storeName)
        }   
    }
}
</script>


<style scoped>

</style>