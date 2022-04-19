<template>
    <v-container>
        <header-view></header-view>
        <br>
        <drop-down></drop-down>
     <div align="center">
       

        <k-1-check-brand-read v-if="BrandCheckBoard" :BrandCheckBoard="BrandCheckBoard" :boardNo="boardNo"/>
        <p v-else>로딩중 ...... </p>

       <div v-if="userInfo.id == BrandCheckBoard.id" style="padding:20px;">
            <router-link style="text-decoration: none; color:black" 
            :to="{ name: 'K1CheckBrandModifyPage', params: { boardNo } }">
                <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 90px;">
                    수정하기
                </v-btn>
            </router-link>


            <v-btn text color="black" rounded x-large
                style="padding: 10px; width: 90px;" 
                @click="onDelete">
                    삭제하기
            </v-btn>
       </div>

            <br>

            <router-link style="text-decoration: none; color:black"
            :to="{ name: 'K1CheckBrandView' }">
                <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 90px;">
                목록으로
                </v-btn>
            </router-link>
        </div>
    

    </v-container>
</template>
<script>
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
import HeaderView from '@/components/home/headerView.vue'
import DropDown from '@/components/KategoriePage1/DropDown.vue'
import K1CheckBrandRead from '@/components/BrandCheckBoard/K1CheckBrandRead.vue'
export default {
    name:'K1CheckBrandReadPage',
    components:{ 
    HeaderView,
    DropDown,
    K1CheckBrandRead,
    },
   
    props: {
        boardNo: {
            type: String,
            required: true
        }   
    },
   
    computed: {
        ...mapState(['BrandCheckBoard','userInfo'])
    },
    created () {
        this.fetchBrandCheckBoard(this.boardNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
      ...mapActions(['fetchBrandCheckBoard']),

        onDelete () {
            var result = confirm('삭제 하시겠습니까?')
            if(result) {
                const { boardNo } = this.BrandCheckBoard
                axios.delete(`http://localhost:7777/BrandCheckBoard/${boardNo}`)
                        .then(() => {
                            alert('삭제 되었습니다.')
                            this.$router.push({ name: 'K1CheckBrandView' })
                        })
                        .catch(err => {
                            alert(err.response.data.message)
                        })
            }
        }
    }
}
</script>