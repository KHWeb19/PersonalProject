<template>
  <v-row class="fill-height">
    <v-col>
      <v-sheet height="100"> <!-- 캘린더와 3월 사이 차이 -->
        <v-toolbar flat="flat" align="center">
          <v-btn fab="fab" text="text" small="small" color="grey darken=-2" @click="prev">
            <v-icon small="small">
              mdi-chevron-left
            </v-icon>
          </v-btn>
          <v-toolbar-title v-if="$refs.calendar">
            {{ $refs.calendar.title }} <!-- 해당 달-->
          </v-toolbar-title>
          <v-btn fab="fab" text="text" small="small" color="grey darken=-2" @click="next">
            <v-icon small="small">
              mdi-chevron-right
            </v-icon>
          </v-btn>
        </v-toolbar>

      </v-sheet>
      <v-sheet height="100%">
        <v-calendar ref="calendar" v-model="focus" color="primary" :type="type">
        </v-calendar>

      </v-sheet>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: "CalendarComponents",
  data() {
    return{
      focus: '',
      type: 'month',
    }
  },
  methods: {
    viewDay ({ date }) {
      this.focus = date
      this.type = 'day'
    },
    prev () {
      this.$refs.calendar.prev()
    },
    next () {
      this.$refs.calendar.next()
    },

  }
}
</script>

<style scoped>

</style>