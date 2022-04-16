<template>
  <div>
    <menu-bar/>
    <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
    <board-register-form :member="member" :memberNo="memberNo" @submit="onSubmit"/>
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
      props: {
        memberNo: {
            type: String,
            required: true
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
          console.log(this.memberNo)
          const memberNo = this.memberNo
            const { boardImage, writer, content } = payload
            axios.post(`http://localhost:7777/board/register/${memberNo}`, { boardImage, writer, content})
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