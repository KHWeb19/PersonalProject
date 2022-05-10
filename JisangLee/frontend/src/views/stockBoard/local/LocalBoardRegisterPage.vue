<template>
<div align="center">
        <br><br>
        <span id="shadow" class="shadow">국내 주식 분석</span>
        <br><br>
        <local-board-register-form @submit="onSubmit"/>
</div>
</template>

<script>
import swal from 'sweetalert';
import LocalBoardRegisterForm from '@/components/stockBoard/local/LocalBoardRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'LocalBoardRegisterPage',
    components: {
        LocalBoardRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/localboard/register', { title, writer, content })
                    .then(() => {
                        swal({                                                                              
                            text: "게시물이 등록되었습니다!",
                            icon: "success"
                            })
                            
                        this.$router.push({
                            name: 'LocalBoardListPage'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}
</script>