<template>
  <div>
    <menu-bar/>
    <board-register-form :member="member" @submit="onSubmit"/>
  </div>
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'
import BoardRegisterForm from '@/components/board/BoardRegisterForm.vue'
import axios from 'axios'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'BoardRegisterPage',
  components: {
    MenuBar,
    BoardRegisterForm
  },
  data() {
    return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo')),
    }
  },
  computed: {
        ...mapState(['member'])
    },
       mounted () {
        this.fetchMember()
    },
   methods: {
     ...mapActions(['fetchMember']),
        onSubmit(payload) {
            const { boardImage, writer, content } = payload
            axios.post('http://localhost:7777/board/register', {boardImage, writer, content})
                .then(() => {
                    alert('게시물 등록 성공!')

                    this.$router.push({
                        name: 'HomeView'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }    
    }
}
</script>

<style>


</style>