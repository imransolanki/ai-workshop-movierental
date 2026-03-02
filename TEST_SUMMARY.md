# Customer Statement Test Summary

## Overview
Comprehensive test suite for the `Customer.statement()` method covering all pricing scenarios and business rules.

## Test Coverage (11 tests)

### Edge Cases
- **statementWithNoRentals**: Empty rental list returns zero amount and points

### Regular Movies ($2 base + $1.50/day after 2 days)
- **statementWithSingleRegularRentalUnderThreshold**: 2 days → $2.00
- **statementWithSingleRegularRentalOverThreshold**: 3 days → $3.50
- **statementWithLongRegularRental**: 10 days → $14.00

### New Release Movies ($3/day + bonus point for 2+ days)
- **statementWithSingleNewReleaseOneDayRental**: 1 day → $3.00, 1 point
- **statementWithSingleNewReleaseTwoDayRental**: 2 days → $6.00, 2 points (bonus)
- **statementWithLongNewReleaseRental**: 5 days → $15.00, 2 points

### Children's Movies ($1.50 base + $1.50/day after 3 days)
- **statementWithSingleChildrensRentalUnderThreshold**: 3 days → $1.50
- **statementWithSingleChildrensRentalOverThreshold**: 4 days → $3.00
- **statementWithLongChildrensRental**: 7 days → $7.50

### Integration
- **statementWithMultipleRentalsAllTypes**: 6 rentals (all types) → $19.00, 7 points

## Test Results
✅ All 11 tests passing
