import {
    FETCH_CAKE_LISTS,
    FETCH_BOOKING_LISTS,
    FETCH_BOOKING_BOARD
}from './mutation-types'

export default {
    [FETCH_CAKE_LISTS] (state, cakeLists) {
        state.cakeLists = cakeLists
    },
    [FETCH_BOOKING_LISTS] (state, bookingLists) {
        state.bookingLists = bookingLists
    },
    [FETCH_BOOKING_BOARD] (state, BookingBoard) {
        state.BookingBoard = BookingBoard
    }
}