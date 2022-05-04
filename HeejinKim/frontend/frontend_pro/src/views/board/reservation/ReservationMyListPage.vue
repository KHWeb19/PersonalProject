<template>
    <div class="Main">


        <div class="myPage">
            <reservation-my-list :reservationIdLists="reservationIdLists"></reservation-my-list>
        </div>
        


    </div>
</template>

<script>



import { mapState, mapActions } from 'vuex'
import ReservationMyList from '@/components/board/reservation/ReservationMyList.vue'

    export default {
        name: 'ReservationMyListPage',
        components:{

            ReservationMyList
        },
        props: {
            id: {
                type: String,
                required: true
            }
        },
        data () {
            return {
                searchId:''
            }
        }
        ,
        computed: {
            ...mapState(['reservationIdLists'])
        },
        mounted() {
            this.id=this.$store.state.session.userId
            this.fetchReservationIdLists(this.id)
        },
        methods: {
            ...mapActions(['fetchReservationIdLists'])
        }
    }
</script>

